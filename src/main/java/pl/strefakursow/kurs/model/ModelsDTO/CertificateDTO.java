package pl.strefakursow.kurs.model.ModelsDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.strefakursow.kurs.commons.Changer;
import pl.strefakursow.kurs.model.Certificate;
import pl.strefakursow.kurs.model.Employer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO implements Changer<Certificate,CertificateDTO> {
    @Override
    public CertificateDTO map(Certificate from) {
        return new CertificateDTO().builder().nazwa(from.getNazwa()).employer(from.getEmployer()).build();
    }
    private String nazwa;
    private Employer employer;
}
