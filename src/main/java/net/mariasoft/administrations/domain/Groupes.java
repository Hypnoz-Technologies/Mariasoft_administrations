package net.mariasoft.administrations.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cmm_groupe")
@Where(clause = "flag_etat <> 'DELETED'")
@SQLDelete(sql = "UPDATE commun_groupes SET flag_etat = 'DELETED' WHERE grp_id = ?", check = ResultCheckStyle.COUNT)
public class Groupes extends AbstractAuditingEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grpCode;
    private String grpLibelle;

}
