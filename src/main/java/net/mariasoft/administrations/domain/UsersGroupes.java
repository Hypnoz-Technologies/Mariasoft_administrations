package net.mariasoft.administrations.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "commun_users_groupes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersGroupes  {
    @EmbeddedId
    private UsersGroupeId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @MapsId("groupeId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "groupe_id", nullable = false)
    private Groupes groupe;


}
