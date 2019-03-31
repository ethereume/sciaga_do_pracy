package pl.strefakursow.kurs.controllers;




import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.kurs.model.Employer;
import pl.strefakursow.kurs.model.ModelsDTO.EmployerDTO;
import pl.strefakursow.kurs.model.Work;
import pl.strefakursow.kurs.services.StudentService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/employer/v1")
public class EmployerController {
    private StudentService service;

    public EmployerController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/",produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EmployerDTO> index(){
        return service.gerEmployers();
    }
    @PostMapping(value = "/",produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEmployer(@RequestBody EmployerDTO e){
        Employer employer = new Employer();
        employer.setName(e.getName());
        employer.setSalary(e.getSalary());
        employer.setSurname(e.getSurname());
        employer.setWork(new Work(e.getWork().getName(),e.getWork().isPromoted()));
        service.addEmployer(employer);
    }
    @PutMapping(value = "/{id}",produces = "application/json")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteEmployer(@PathVariable int id, @RequestBody Optional<EmployerDTO> employerDTO){
/*        System.out.println(employerDTO.get());
        System.out.println(id);*/
        service.update(id,employerDTO);
    }
    @DeleteMapping(value = "/{id}",produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteEmployerById(@PathVariable int id){
        service.romoveEmployersById(id);
    }

    @GetMapping(value = "/promoted/{ispromoted}",produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EmployerDTO> getPromotedEmployers(@PathVariable boolean ispromoted) {
        return service.getPromotedEmployers(ispromoted);
    }
}
