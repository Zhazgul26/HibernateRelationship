package peaksoft.service.Impl;

import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.Impl.CourseRepositoryImpl;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    CourseRepository courses = new CourseRepositoryImpl();

    @Override
    public void saveCourse(Course course) {
        courses.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courses.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courses.getAllCourse();
    }

    @Override
    public void updateCourse(Long id, Course course) {
courses.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Long id) {
courses.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courses.getCourseByName(name);
    }
}
