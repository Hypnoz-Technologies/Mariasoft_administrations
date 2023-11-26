package net.mariasoft.administrations.web.rest.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private String code;

}
