package co.com.sofka.model.team;
import co.com.sofka.model.cyclist.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private String idTeam;
    private String nameTeam;
    private String CodeTeam;
    private String countryTeam;
    private Set<Cyclist> cyclists;

}
