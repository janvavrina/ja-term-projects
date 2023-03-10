package cz.mendelu.ja.xvavrina.projekt3.User;

import cz.mendelu.ja.xvavrina.projekt3.Team.Team;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    @Nonnull
    private String firstName;

    @Column(name = "last_name")
    @Nonnull
    private String lastName;

    @Column(name = "email")
    @Nonnull
    private String email;

    @Column(name = "username")
    @Nonnull
    private String username;

    @JoinColumn(name = "teams_name")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
