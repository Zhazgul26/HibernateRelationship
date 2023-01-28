package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;


    @ManyToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "intstructor_course",joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Course> course = new ArrayList<>();


    public Instructor(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Instructor :" +
                " id=" + id +
                " firstName=" + firstName + '\'' +
                " lastName=" + lastName + '\'' +
                " email=" + email + '\'' +
                " phoneNumber=" + phoneNumber;

    }
}
