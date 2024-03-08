package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "website")
    private String website;

    @OneToOne(mappedBy = "user")
    private Address address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "user")
    private Company company;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;
}
