package net.mariasoft.administrations.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * DTO for {@link net.mariasoft.administrations.domain.CommunCommunication}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommunicationDto implements Serializable {
    Long id;
    String usrMail;
    String usrSkype;
    String usrMsn;
    String usrYahoo;
    String usrTelBureau;
}