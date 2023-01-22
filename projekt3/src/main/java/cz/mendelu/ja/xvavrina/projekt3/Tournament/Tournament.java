package cz.mendelu.ja.xvavrina.projekt3.Tournament;

import com.electronwill.nightconfig.core.conversion.PreserveNotNull;
import cz.mendelu.ja.xvavrina.projekt3.Location;
import cz.mendelu.ja.xvavrina.projekt3.Team.Team;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tournaments")
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "TeamOnTournament",
            joinColumns = @JoinColumn(name = "id", insertable = false,updatable = false),
            inverseJoinColumns = @JoinColumn(name = "name", insertable = false,updatable = false))
    private List<Team> teamsOnTournament;

    @Column(name = "date")
    @Nonnull
    private LocalDate date;

    @Nonnull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    @Nonnull
    private String description;

    @Column(name = "team_size")
    @Nonnull
    private Integer teamSize;

    @Nonnull
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private Location location;
}
