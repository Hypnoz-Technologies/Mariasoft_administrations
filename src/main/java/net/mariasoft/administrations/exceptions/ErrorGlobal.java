package net.mariasoft.administrations.exceptions;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ErrorGlobal {
    Date timestamp;
    String title;
    Integer status;
    List<String> errors;
    String instance;
}
