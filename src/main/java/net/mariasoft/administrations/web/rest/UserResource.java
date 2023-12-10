package net.mariasoft.administrations.web.rest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.mariasoft.administrations.dtos.StructuresDto;
import net.mariasoft.administrations.dtos.UsersDto;
import net.mariasoft.administrations.service.users.UsersService;
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
import java.util.List;


@RestController
@DefaultErrorApiResponse
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
    private static final String ENTITY_NAME = "users";
    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    @Value("${mariasoft.clientApp.name}")
    private String applicationName;
    private final UsersService usersService;

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Creation Users avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsersDto> creationStructure(@Valid @RequestBody UsersDto usersDto) {
        log.debug("REST request to save users : {}", usersDto);
        try {
            if (usersDto.getId() != null) {
                throw new BadRequestAlertException("A new users cannot already have an ID", "userManagement", "idexists");
            }
            UsersDto result = usersService.createUsers(usersDto);
            return ResponseEntity.created(new URI(MessageFormat.format("/api/users/{0}", result.getId())))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getUsrNom()))
                    .body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(usersDto);
        }
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Found user avec Success", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    StructuresDto.class))})
            }
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsersDto> getUsersById(@PathVariable Long id) {
        log.debug("REST request to get users : {}", id);
        UsersDto result = usersService.getUsersById(id);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getUsrNom()))
                .body(result);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successfully get all Users", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    UsersDto.class))})
            }
    )
    @GetMapping("/{sid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsersDto>> getAllUsers(@PathVariable Long sid) {
        log.debug("REST request to get all users");
        List<UsersDto> result = usersService.getAllUsers(sid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Successful user deletion", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
            }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete User : {}", id);
        usersService.deleteUsers(id);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successful user update", content =
                            {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
                                    UsersDto.class))})
            }
    )
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsersDto> updateUser(@Valid @RequestBody UsersDto usersDto) {
        log.debug("REST request to update User : {}", usersDto);
        if (usersDto.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UsersDto result = usersService.updateUsers(usersDto);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getUsrNom()))
                .body(result);
    }
}

