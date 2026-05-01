package isgb.java.Oumi.Controller;

import isgb.java.Oumi.Model.Departement;
import isgb.java.Oumi.Repository.DepartementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartementController {

    private final DepartementRepository departementRepository;

    public DepartementController(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @GetMapping("/{id}")
    public Departement getDepartementById(@PathVariable Integer id) {
        return departementRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Departement> searchByName(@RequestParam String name) {
        return departementRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/school/{schoolId}")
    public List<Departement> getDepartementsBySchool(@PathVariable Integer schoolId) {
        return departementRepository.findBySchoolIdSchool(schoolId);
    }

    @PostMapping
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementRepository.save(departement);
    }

    @PutMapping("/{id}")
    public Departement updateDepartement(@PathVariable Integer id,
                                         @RequestBody Departement updated) {

        Departement dep = departementRepository.findById(id).orElse(null);

        if (dep == null) return null;

        dep.setName(updated.getName());
        dep.setSchool(updated.getSchool());

        return departementRepository.save(dep);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Integer id) {
        departementRepository.deleteById(id);
    }
}
