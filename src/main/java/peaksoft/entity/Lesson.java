package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "video_link")
    private String videoLink;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "lesson")
    private List<Task> tasks;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = FetchType.EAGER)
    private Course course;
    public void addTasksToLesson(Task task) {
        this.tasks.add(task);
    }

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "Lesson" +
                " id=" + id +
                " name=" + name + '\'' +
                " videoLink=" + videoLink;

    }
}
