package net.mariasoft.administrations.web.rest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.service.structres.StructureService;
import net.mariasoft.administrations.web.rest.errors.BadRequestAlertException;
import net.mariasoft.administrations.web.rest.errors.DefaultErrorApiResponse;
import net.mariasoft.administrations.web.rest.errors.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.MessageFormat;

@RestController
@DefaultErrorApiResponse
@RequestMapping("/api/structures")
public class StructureResource {
    private static final String ENTITY_NAME = "structures";
    private final Logger log = LoggerFactory.getLogger(StructureResource.class);
    @Value("${mariasoft.clientApp.name}")
    private String applicationName;
    private final StructureService structureService;

    public StructureResource(StructureService structureService) {
        this.structureService = structureService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Creation Structure avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StructuresDto> creationStructure(@Valid @RequestBody StructuresDto structuresDto) {
        log.debug("REST request to save Structure : {}", structuresDto);
        try {
            if(structuresDto.getId() != null) {
                throw new BadRequestAlertException("A new structure cannot already have an ID", "userManagement", "idexists");
            }
            StructuresDto result = structureService.creationStructure(structuresDto);
            return ResponseEntity.created(new URI(MessageFormat.format("/api/structures/{0}", result.getId())))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getStrRaisonSociale()))
                    .body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(structuresDto);
        }
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found Structure avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @GetMapping("/{sid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<StructuresDto> getStructure(@PathVariable("sid") Long sid) {
        log.debug("REST request to get Structure : {}", sid);
        StructuresDto result = structureService.getStructure(sid);
        return ResponseEntity.accepted().headers(HeaderUtil.createEntityCreationAlert(applicationName, true,
                ENTITY_NAME, result.getStrRaisonSociale())).body(result);
    }
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "update Structure avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StructuresDto> updateStructure(@Valid @RequestBody StructuresDto structuresDto){
        log.debug("REST request to update Structure : {}", structuresDto);
        try {
            if(structuresDto.getId() == null) {
                throw new BadRequestAlertException("A update structure cannot already haven't an ID", "userManagement", "idnotexists");
            }
            StructuresDto result = structureService.updateStructure(structuresDto);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getStrRaisonSociale()))
                    .body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(structuresDto);
        }
    }
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Delete Structure avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @DeleteMapping("/{sid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteStructure(@PathVariable("sid") Long sid){
        log.debug("REST request to delete Structure : {}", sid);
        try {
            structureService.deleteStructure(sid);
            return ResponseEntity.ok()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, sid.toString()))
                    .build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
