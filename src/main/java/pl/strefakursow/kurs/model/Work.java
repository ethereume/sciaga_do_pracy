package pl.strefakursow.kurs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "work")
public class Work {
    public Work(String name, boolean isPromoted) {
        this.name = name;
        this.isPromoted = isPromoted;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "promoted")
    private boolean isPromoted;
    @OneToOne(mappedBy = "work",cascade = CascadeType.ALL)
    private Employer employer;
}
