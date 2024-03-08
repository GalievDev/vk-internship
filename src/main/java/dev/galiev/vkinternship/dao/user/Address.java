package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "address")
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zipCode")
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Geo geo;

    @Column(name = "suite")
    private String suite;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
