package net.mariasoft.administrations.web.rest;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import net.mariasoft.administrations.MariasoftAdministrationsApplication;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.utils.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = MariasoftAdministrationsApplication.class)
 class StructureResourceTest {
    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper= new ObjectMapper();


    @BeforeAll
    static void setUpTest(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    @Test
    void createStructure() throws Exception {
        try {
            String expectedJsonFilename = "structure_post.json";
            File expectedJsonFile = new ClassPathResource(expectedJsonFilename).getFile();

            if (!expectedJsonFile.exists()) {
                fail("Expected JSON file not found: " + expectedJsonFilename);
            }

            MvcResult mvcResult = mockMvc
                    .perform(
                            post("/api/structures")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(FileUtils.getJsonfromFile(expectedJsonFilename))
                    )
                    .andExpect(status().isCreated())
                    .andReturn();

            String responseBody = mvcResult.getResponse().getContentAsString();
            StructuresDto actualStructuresDto = mapper.readValue(responseBody, StructuresDto.class);
            StructuresDto expectedStructuresDto = mapper.readValue(expectedJsonFile, StructuresDto.class);

            assertThat(actualStructuresDto.getStrSigle())
                    .as("Checking that the actual sigle matches the expected sigle")
                    .isEqualTo(expectedStructuresDto.getStrSigle());
        } catch(IOException e){
            fail("Failed with IOException: " + e.getMessage());
        }
    }

}
