package edu.isgb.school.Repository;

import edu.isgb.school.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité School.
 * Réalisé par : Membre 1
 *
 * Spring Data JPA génère automatiquement les implémentations
 * des méthodes CRUD de base via JpaRepository.
 */
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    // Trouver une école par nom
    Optional<School> findByName(String name);

    // Trouver les écoles dont le nom contient une chaîne (insensible à la casse)
    List<School> findByNameContainingIgnoreCase(String name);

    // Requête JPQL personnalisée pour charger une School avec ses Departments
    @Query("SELECT s FROM School s LEFT JOIN FETCH s.departments WHERE s.idSchool = :id")
    Optional<School> findByIdWithDepartments(Integer id);

    // Requête JPQL pour charger une School avec tous ses étudiants
    @Query("SELECT s FROM School s LEFT JOIN FETCH s.students WHERE s.idSchool = :id")
    Optional<School> findByIdWithStudents(Integer id);
}
