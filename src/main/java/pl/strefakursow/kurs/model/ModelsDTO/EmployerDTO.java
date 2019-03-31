package pl.strefakursow.kurs.model.ModelsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.strefakursow.kurs.model.Employer;
import pl.strefakursow.kurs.commons.Changer;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployerDTO implements Changer<Employer,EmployerDTO> {
    @Override
    public EmployerDTO map(Employer from) {
        return new EmployerDTO().builder()
                .name(from.getName())
                .surname(from.getName())
                .salary(from.getSalary())
                .work(
                        new WorkDTO().builder()
                                .name(from.getWork().getName())
                                .isPromoted(from.getWork().isPromoted())
                                .build())
                .certificate(
                        from.getCertificates()
                                .stream()
                                .map(c-> new CertificateDTO().builder().nazwa(c.getNazwa()).employer(c.getEmployer()).build())
                                .collect(Collectors.toList()))
                .build();
    }
    private String name;
    private String surname;
    private BigDecimal salary;
    private WorkDTO work;
    private List<CertificateDTO> certificate;
}
