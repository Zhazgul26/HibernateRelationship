package peaksoft.service.Impl;

import peaksoft.entity.Instructor;
import peaksoft.repository.Impl.InstructorRepositoryImpl;
import peaksoft.repository.InstructorRepository;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository = new InstructorRepositoryImpl();


    @Override
    public void saveInstructor(Instructor instructor) {
instructorRepository.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
  instructorRepository.updateInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorRepository.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
instructorRepository.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long id) {
instructorRepository.assignInstructorToCourse(courseId, id);
    }
}
