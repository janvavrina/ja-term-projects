package cz.mendelu.ja.xvavrina.projekt3.Team;

import cz.mendelu.ja.xvavrina.projekt3.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<User> players;
}
