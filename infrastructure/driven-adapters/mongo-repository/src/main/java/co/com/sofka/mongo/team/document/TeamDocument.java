package co.com.sofka.mongo.team.document;

import co.com.sofka.model.cyclist.Cyclist;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@NoArgsConstructor
public class TeamDocument {
    @Id
    private String idTeam;
    private String nameTeam;
    @Indexed(unique = true)
    private String codeTeam;
    private String countryTeam;
    private Set<Cyclist> cyclists;

}
