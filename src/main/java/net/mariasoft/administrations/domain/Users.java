package net.mariasoft.administrations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commun_users")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE cmm_users SET flag_etat = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Users extends AbstractAuditingEntity<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column(name = "usr_civilite")
    private String usrCivilite;

    @Column(name = "usr_nom")
    private String usrNom;

    @Column(name = "usr_prenom")
    private String usrPrenom;
    @Column(name = "usr_patronyme")
    private String usrPatronyme;

    @Column(name = "usr_initiale")
    private String usrInitiale;

    @Column(name = "usr_photo")
    private String usrPhoto;

    @Column(name = "usr_identifiant")
    private String usrIdentifiant;

    @Column(name = "usr_matricule")
    private String usrMatricule;
    @Column(name = "usr_password")
    private String usrPassword;
    @Column(name = "usr_login")
    private String usrLogin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_address_id", referencedColumnName = "id")
    private CommunAdresse userAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_communication_id", referencedColumnName = "id")
    private CommunCommunication userCommunication;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupes_id")
    private Groupes groupes;

}

