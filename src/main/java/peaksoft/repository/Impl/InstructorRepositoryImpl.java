package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;

import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository, AutoCloseable {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {


    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.createQuery("select i from  Instructor i", Instructor.class).getResultStream().filter(i -> i.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().begin();
        entityManager.close();
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long course_id) {
        entityManager.getTransaction().begin();
        List<Instructor> instructorList = entityManager.createQuery("select i from Instructor i join Course c ON c.id = i.id ", Instructor.class).getResultStream().filter(c -> c.getId().equals(course_id)).toList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructorList;
    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignInstructorToCourse(Long id, Long course_id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        Course course = entityManager.find(Course.class,course_id);
        instructor.getCourse().add(course);
        course.getInstructors().add(instructor);
        entityManager.persist(instructor);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
