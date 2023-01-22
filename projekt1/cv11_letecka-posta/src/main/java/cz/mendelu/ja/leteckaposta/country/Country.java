package cz.mendelu.ja.leteckaposta.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Collection;

@Data
@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String cca3;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "boarders",
            joinColumns = { @JoinColumn(name = "country_cca3") },
            inverseJoinColumns = { @JoinColumn(name = "neighbour_cca3") }
    )
    @JsonIgnore
    private Collection<Country> borders;

    @Embedded
    private City capital;

    public Country(String cca3){this.cca3 = cca3;}
}
