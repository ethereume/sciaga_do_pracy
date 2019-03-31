package pl.strefakursow.kurs.services;

import org.springframework.stereotype.Service;
import pl.strefakursow.kurs.model.Employer;
import pl.strefakursow.kurs.model.ModelsDTO.EmployerDTO;
import pl.strefakursow.kurs.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public StudentService(StudentRepository studentService, EmployerDTO employerDTO) {
        this.studentService = studentService;
        this.employerDTO = employerDTO;
    }
    public List<EmployerDTO> getEmployersBySalary(double salary){
        return converEmployersToEmployersDTO(studentService.getEmployerBySalaryGreaterThan(salary));
    }
    public List<EmployerDTO> gerEmployers(){
        return converEmployersToEmployersDTO(studentService.findAll());
    }
    public void addEmployer(Employer e) {
        this.studentService.save(e);
    }
    public List<EmployerDTO> getPromotedEmployers(boolean isPromoted){
        Optional<List<Employer>> employers = Optional.ofNullable
                        (this.studentService.getEmployerByIdWhereWorkIsPromoted(isPromoted)
                        .orElse(null));
        List<EmployerDTO> employerDTOS = new ArrayList<>();
               if(employers.isPresent()){
                   employers.get().forEach(c->{
                       employerDTOS.add(employerDTO.map(c));
                   });
               }else  {
                   throw new NullPointerException();
               }
        return employerDTOS;
    }
    public void update(int id,Optional<EmployerDTO> employerDTO){
        Optional<Employer> employer = Optional.ofNullable(this.studentService.getEmployerById(id)).orElse(null);
        if(employerDTO.isPresent() && employer.isPresent()){
            employer.get().setName(employerDTO.get().getName());
            employer.get().setSalary(employerDTO.get().getSalary());
            employer.get().setSurname(employerDTO.get().getSurname());
            studentService.save(employer.get());
        } else {
            throw new NullPointerException("Nie ma Employera w bazie danych");
        }
    }
    public void romoveEmployersById(Integer id){
        studentService.deleteById(id);
    }
    private List<EmployerDTO> converEmployersToEmployersDTO(List<Employer> lista){
        List<EmployerDTO> employerDTOS = new ArrayList<>();
        lista.forEach(c->{
            employerDTOS.add(employerDTO.map(c));
        });
        return employerDTOS;
    }

    private StudentRepository studentService;
    private EmployerDTO employerDTO;
}
