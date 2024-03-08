package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
}
