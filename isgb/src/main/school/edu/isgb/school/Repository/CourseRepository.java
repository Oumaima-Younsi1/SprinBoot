package edu.isgb.school.Repository;

import edu.isgb.school.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour l'entité Course.
 * Réalisé par : Membre 3
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Trouver les cours par nom
    List<Course> findByNameContainingIgnoreCase(String name);

    // Lister les cours d'un instructeur (question i du service)
    @Query("SELECT c FROM Course c JOIN c.instructors i WHERE i.idInstructor = :instructorId")
    List<Course> findCoursesByInstructorId(Integer instructorId);
}
