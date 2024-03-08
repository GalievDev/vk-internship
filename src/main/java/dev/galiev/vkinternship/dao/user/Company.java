package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "company")
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bs")
    private String bs;

    @Column(name = "catch_phrase")
    private String catchPhrase;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Company() {
    }

    public Company(String bs, String catchPhrase, String name, User user) {
        this.bs = bs;
        this.catchPhrase = catchPhrase;
        this.name = name;
        this.user = user;
    }
}
