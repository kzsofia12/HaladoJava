package hu.unimiskolc.hu.university.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Length( max = 70)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length( max = 70)
    private String major;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course", joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    })
    private Set<Course> courses;
}
