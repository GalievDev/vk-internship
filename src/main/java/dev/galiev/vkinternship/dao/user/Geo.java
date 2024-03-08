package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "geo")
@Table(name = "geos")
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lng")
    private String lng;

    @Column(name = "lat")
    private String lat;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Geo() {
    }

    public Geo(String lng, String lat, Address address) {
        this.lng = lng;
        this.lat = lat;
        this.address = address;
    }
}
