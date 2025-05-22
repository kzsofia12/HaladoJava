package hu.unimiskolc.hu.university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Length(max = 70)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(max = 100)
    private String faculty;

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;
}
