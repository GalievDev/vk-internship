package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
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

    public User() {
    }

    public User(String website, Address address, String phone, String name, Company company, String email, String username) {
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.company = company;
        this.email = email;
        this.username = username;
    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
