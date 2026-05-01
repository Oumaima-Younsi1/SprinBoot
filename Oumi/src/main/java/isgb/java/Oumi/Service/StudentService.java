package isgb.java.Oumi.Service;

import isgb.java.Oumi.Model.School;
import isgb.java.Oumi.Model.Student;
import isgb.java.Oumi.Repository.SchoolRepository;
import isgb.java.Oumi.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private SchoolRepository schoolRepository;

    public Student createStudent(Student student, int schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School non trouvée"));

        student.setSchool(school);
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
