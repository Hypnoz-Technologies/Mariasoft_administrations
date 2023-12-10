package net.mariasoft.administrations.web.rest;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.mariasoft.administrations.MariasoftAdministrationsApplication;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.service.structres.StructureService;
import net.mariasoft.administrations.utils.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = MariasoftAdministrationsApplication.class)
 class StructureResourceTI {
    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper= new ObjectMapper();
    @MockBean
    private StructureService structureService;


    @BeforeAll
    static void setUpTest(){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    @Test
    void createStructure() throws Exception {
        try {
            String expectedJsonFilename = "json/requests/structure_post.json";
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

    @Test
    void updateStructure() throws Exception {
        try {
            String expectedJsonFilename = "json/requests/structure_put.json";
            File expectedJsonFile = new ClassPathResource(expectedJsonFilename).getFile();

            if (!expectedJsonFile.exists()) {
                fail("Expected JSON file not found: " + expectedJsonFilename);
            }

            MvcResult mvcResult = mockMvc
                    .perform(
                            put("/api/structures")
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
