package isgb.java.Oumi.Repository;

import isgb.java.Oumi.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository pour l'entité Address.
 * Réalisé par : Membre 2
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    // Trouver les adresses par ville
    List<Address> findByCity(String city);

    // Trouver les adresses par code postal
    List<Address> findByPostalCode(String postalCode);
}
