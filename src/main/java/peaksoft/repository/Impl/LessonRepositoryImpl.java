package peaksoft.repository.Impl;


import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    private final SessionFactory sessionFactory = HibernateConfig.creatSessionFactory();

    @Override
    public void saveLesson(Long course_id, Lesson lesson) {
        entityManager.getTransaction().begin();
        entityManager.find(Lesson.class, course_id);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
   entityManager.getTransaction().begin();
   Lesson lesson1 = entityManager.find(Lesson.class,id);
   lesson1.setName(lesson.getName());
   lesson1.setVideoLink(lesson.getVideoLink());
   entityManager.persist(lesson1);
   entityManager.getTransaction().commit();
   entityManager.close();
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class, id);
            if (lesson == null) {
                System.out.println("_-_-_-_-_-_-_-_-_-_- Пусто, нет такого урока! -_-_-_-_-_-_-_-_-_-_-");
            }
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (getLessonById)! -_-_-_-_-_-_-_-_-_-_-");
        }
        return null;
    }



    @Override
    public List<Lesson> getLessonByCourseId(Long course_id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,course_id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return lessons;
        } catch(Exception e){
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка! ---> (getLessonsByCourseId)! -_-_-_-_-_-_-_-_-_-_-");
        }
        return null;
    }
}
