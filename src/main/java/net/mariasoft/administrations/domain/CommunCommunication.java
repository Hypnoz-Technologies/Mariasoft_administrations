package net.mariasoft.administrations.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commun_communication")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE commun_communication SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)

public class CommunCommunication extends AbstractAuditingEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_mail")
    private String usrMail;

    @Column(name = "usr_skype")
    private String usrSkype;

    @Column(name = "usr_msn")
    private String usrMsn;

    @Column(name = "usr_yahoo")
    private String usrYahoo;

    @Column(name = "usr_tel_bureau")
    private String usrTelBureau;

}
