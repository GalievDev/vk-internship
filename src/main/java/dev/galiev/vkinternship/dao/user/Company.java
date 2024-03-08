package dev.galiev.vkinternship.dao.user;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "company")
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bs")
    private String bs;

    @Column(name = "catchPhrase")
    private String catchPhrase;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
