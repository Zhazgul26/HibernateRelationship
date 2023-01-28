package peaksoft.service.Impl;

import peaksoft.entity.Lesson;
import peaksoft.repository.Impl.LessonRepositoryImpl;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
     LessonRepository lessonRepository = new LessonRepositoryImpl();



    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
lessonRepository.saveLesson(courseId, lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
lessonRepository.updateLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        return lessonRepository.getLessonByCourseId(id);
    }
}
