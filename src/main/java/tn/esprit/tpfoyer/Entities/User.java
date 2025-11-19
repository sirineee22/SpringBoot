package tn.esprit.tpfoyer.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter // Ajouter explicitement
@Setter // Ajouter explicitement
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    @Column(nullable = true)
    private String password;

}