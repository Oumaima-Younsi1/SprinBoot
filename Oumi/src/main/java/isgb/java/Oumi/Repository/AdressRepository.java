package isgb.java.Oumi.Repository;

import isgb.java.Oumi.Model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour l'entité Address.
 * Réalisé par : Membre 2
 */
@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

    // Trouver les adresses par ville
    List<Adress> findByCity(String city);

    // Trouver les adresses par code postal
    List<Adress> findByPostalCode(String postalCode);
}
