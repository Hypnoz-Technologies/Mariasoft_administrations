package net.mariasoft.administrations.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "commun_users_structures")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersStructures {
    @EmbeddedId
    private UsersStructuresId usersStructuresId;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @MapsId("structuresId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "structure_id", nullable = false)
    private Structures structures;
}
