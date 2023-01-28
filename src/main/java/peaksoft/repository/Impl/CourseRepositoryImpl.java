package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    private final SessionFactory sessionFactory = HibernateConfig.creatSessionFactory();

    @Override
    public void saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course getCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class, id);
            if (course == null) {
                System.out.println(" _-_-_-_-_-_-_-_-_-_- Пусто, нет такого курса! -_-_-_-_-_-_-_-_-_-_-");
            }
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка ---> (getCourseById)! -_-_-_-_-_-_-_-_-_-_-");
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createNativeQuery("select c from Course c").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }


    @Override
    public void updateCourse(Long id, Course course) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course updatedCourse = session.find(Course.class, id);
            updatedCourse.setName(course.getName());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setDuration(course.getDuration());
            updatedCourse.setLessons(course.getLessons());
            updatedCourse.setCreateAt(course.getCreateAt());
            updatedCourse.setImageLink(course.getImageLink());
            updatedCourse.setInstructors(course.getInstructors());
            session.merge(updatedCourse);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка ---> (updateCourse)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }


    @Override
    public void deleteCourseById(Long id) {
        try {
            EntityManager entityManager1 = entityManager.getEntityManagerFactory().createEntityManager();
            entityManager1.getTransaction().begin();
            Course course = entityManager1.find(Course.class, id);
            for (Instructor instructor : course.getInstructors()) {
                instructor.setCourse(null);
            }
            entityManager1.remove(course);
            entityManager1.getTransaction().commit();
            entityManager1.close();
        } catch (Exception e) {
            System.out.println("_-_-_-_-_-_-_-_-_-_- Произошла ошибка ---> (deleteCourse)! -_-_-_-_-_-_-_-_-_-_-");
        }
    }

    @Override
    public Course getCourseByName(String name) {
        entityManager.getTransaction().begin();

        Course course = entityManager.createQuery("select c from Course c ", Course.class).
                getResultStream().filter(c -> c.getName().equals(name)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;

    }
}
