package edu.isgb.school.Repository;

import edu.isgb.school.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour l'entité Student.
 * Réalisé par : Membre 2
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Lister les étudiants par nom
    List<Student> findByNameContainingIgnoreCase(String name);

    // Lister les étudiants d'une école donnée
    List<Student> findBySchoolIdSchool(Integer schoolId);

    // Requête JPQL pour charger un étudiant avec son adresse
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.address WHERE s.idStudent = :id")
    Student findByIdWithAddress(Integer id);
}