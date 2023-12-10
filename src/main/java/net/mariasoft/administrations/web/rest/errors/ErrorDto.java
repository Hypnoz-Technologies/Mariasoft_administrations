package net.mariasoft.administrations.web.rest.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private String code;

    public ErrorDto(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
