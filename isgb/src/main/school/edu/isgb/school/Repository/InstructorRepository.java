package edu.isgb.school.Repository;

import edu.isgb.school.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Instructor.
 * Réalisé par : Membre 3
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    // Lister les instructeurs par nom (question f du service)
    List<Instructor> findByNameContainingIgnoreCase(String name);

    // Trouver les instructeurs d'une école
    @Query("SELECT i FROM Instructor i JOIN i.school s WHERE s.idSchool = :schoolId")
    List<Instructor> findBySchoolId(Integer schoolId);

    // Charger un instructeur avec ses cours (évite LazyInitializationException)
    @Query("SELECT i FROM Instructor i LEFT JOIN FETCH i.courses WHERE i.idInstructor = :id")
    Optional<Instructor> findByIdWithCourses(Integer id);
}
