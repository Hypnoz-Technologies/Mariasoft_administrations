package net.mariasoft.administrations.web.rest.errors;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@CrossOrigin(origins = "*", maxAge = 3600)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "401", description = "Unauthorised", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "403", description = "Forbidden", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "404", description = "Not Found", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "405", description = "Method not Allowed", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "409", description = "Conflit", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "413", description = "Payload To Large", content = {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
                @ApiResponse(responseCode = "500", description = "Une erreur est survenue", content =
                        {@Content(mediaType =
                        "application/json", schema =@Schema(implementation = ErrorDto.class))}),
        }
)
public @interface DefaultErrorApiResponse {
}
