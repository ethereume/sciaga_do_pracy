package pl.strefakursow.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.strefakursow.kurs.model.Employer;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Employer,Integer> {

    public List<Employer> getEmployerBySalaryGreaterThan(double pensja);
    public Optional<Employer> getEmployerById(int id);

    @Query(value = "select e from Employer e where e.work.isPromoted = :isPromoted")
    public Optional<List<Employer>> getEmployerByIdWhereWorkIsPromoted(boolean isPromoted);

}
