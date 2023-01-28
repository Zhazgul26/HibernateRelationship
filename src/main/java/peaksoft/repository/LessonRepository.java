package peaksoft.repository;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonRepository {
    void saveLesson(Long course_id, Lesson lesson);

    void updateLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonByCourseId(Long course_id);

}
