package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "address")
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code")
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

    public Address() {
    }

    public Address(String zipCode, Geo geo, String suite, String city, String street, User user) {
        this.zipCode = zipCode;
        this.geo = geo;
        this.suite = suite;
        this.city = city;
        this.street = street;
        this.user = user;
    }
}
