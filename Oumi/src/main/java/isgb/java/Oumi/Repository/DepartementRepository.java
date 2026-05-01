package isgb.java.Oumi.Repository;

import isgb.java.Oumi.Model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour l'entité Department.
 * Réalisé par : Membre 1
 */
@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    // Trouver tous les départements d'une école donnée
    List<Departement> findBySchoolIdSchool(Integer schoolId);

    // Trouver un département par nom
    List<Departement> findByNameContainingIgnoreCase(String name);
}
