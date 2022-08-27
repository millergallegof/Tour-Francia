package co.com.sofka.model.cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cyclist {
    private String idCyclist;
    private String nameCyclist;
    private Integer competitorNumber;
    private String codeTeam;
    private String countryCyclist;
}
