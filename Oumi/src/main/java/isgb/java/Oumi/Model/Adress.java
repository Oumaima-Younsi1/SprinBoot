package isgb.java.Oumi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="adress")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAddress")
    private Integer idAddress;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name="PostalCode")
    private String postalCode;
}
