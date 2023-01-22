package cz.mendelu.ja.xvavrina.projekt3.Team;

import cz.mendelu.ja.xvavrina.projekt3.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<User> players;
}
