package net.mariasoft.administrations.web.rest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import net.mariasoft.administrations.MariasoftAdministrationsApplication;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.mappers.StructuresMapperImpl;
import net.mariasoft.administrations.repository.StructuresRepository;
import net.mariasoft.administrations.service.impl.StructureService;
import net.mariasoft.administrations.utils.FileUtils;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = MariasoftAdministrationsApplication.class)
class StructureResourceTest {
    @ClassRule
    private static WireMockServer wireMockServer = new WireMockServer(8080);

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    private StructuresDto structuresDto;

    @MockBean
    private StructureService structureService;

    @BeforeAll
    static void setupWireMock() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        objectMapper.registerModule(new JavaTimeModule());
        wireMockServer.start();
    }

    @AfterAll
    static void stopWireMock() {
        wireMockServer.shutdown();
        wireMockServer.shutdownServer();
        wireMockServer.stop();
    }

    @BeforeEach
    void setUp() {
        wireMockServer.resetAll();
    }

    @Test
    void shouldCreatedStructureReturnCreated() throws Exception {
        this.createStructure("json/structures/structurePostOK.json", 201);
        MvcResult mvcResult= mockMvc
                .perform(
                        post("/api/structures")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(FileUtils.getJsonfromFile("json/structures/structurePostOK.json"))
                )
                .andExpect(status().isCreated())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        StructuresDto actualStructuresDto = objectMapper.readValue(responseBody, StructuresDto.class);
        StructuresDto exceptStructuresDto = objectMapper.readValue(FileUtils.getJsonfromFile("json/structures/structurePostOK.json"), StructuresDto.class);
        assertThat(actualStructuresDto).usingRecursiveComparison().ignoringActualNullFields().ignoringFields("id").isEqualTo(exceptStructuresDto);
    }

    private void createStructure(String path,int httpCode) throws Exception {
        wireMockServer.stubFor(
                WireMock.post(WireMock.urlMatching("/api/structures"))
                        .willReturn(aResponse().withStatus(httpCode).withHeader("Content-Type", "application/json")
                                .withBody(FileUtils.getJsonfromFile(path)))
        );
    }
}