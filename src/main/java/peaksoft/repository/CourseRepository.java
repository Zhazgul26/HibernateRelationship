package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    peaksoft.entity.Course getCourseById(Long id);


    List<Course> getAllCourse();

    void updateCourse( Long id,Course course);

    void deleteCourseById(Long id);


    Course getCourseByName(String name);
}

