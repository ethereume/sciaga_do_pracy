package pl.strefakursow.kurs.model.ModelsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.strefakursow.kurs.commons.Changer;
import pl.strefakursow.kurs.model.Work;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkDTO implements Changer<Work,WorkDTO> {
    @Override
    public WorkDTO map(Work from) {
        return new WorkDTO()
                    .builder()
                    .name(from.getName())
                    .isPromoted(from.isPromoted()).build();
    }
    private String name;
    private boolean isPromoted;
}
