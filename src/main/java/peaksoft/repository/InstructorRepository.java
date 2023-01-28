package peaksoft.repository;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorRepository {
    void saveInstructor (Instructor instructor);

    void updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long course_id);

    void  deleteInstructorById(Long id);

    void  assignInstructorToCourse(Long id,Long course_id);

}
