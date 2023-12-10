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
@Table(name = "commun_addresse")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE commun_addresse SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class CommunAdresse extends AbstractAuditingEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_adresse")
    private String usrAdresse;

    @Column(name = "usr_bp")
    private String usrBp;

    @Column(name = "usr_ville")
    private String usrVille;

    @Column(name = "usr_nom_pays")
    private String usrNomPays;

    @Column(name = "usr_region")
    private String usrRegion;

    @Column(name = "usr_code_postal")
    private String usrCodePostal;

    @Column(name = "usr_pays")
    private String usrPays;
}
