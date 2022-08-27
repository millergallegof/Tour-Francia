package co.com.sofka.mongo.cyclist.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class CyclistDocument {
    @Id
    private String idCyclist;
    private String nameCyclist;
    @Indexed(unique = true)
    private Integer competitorNumber;
    private String codeTeam;
    private String countryCyclist;
}
