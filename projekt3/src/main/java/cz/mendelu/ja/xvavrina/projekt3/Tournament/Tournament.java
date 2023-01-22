package cz.mendelu.ja.xvavrina.projekt3.Tournament;

import com.electronwill.nightconfig.core.conversion.PreserveNotNull;
import cz.mendelu.ja.xvavrina.projekt3.Location;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
    private Integer team_size;

    @Nonnull
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private Location location;
}
