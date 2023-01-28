package peaksoft.service.Impl;

import jakarta.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.procedure.internal.Util;
import peaksoft.entity.Task;
import peaksoft.repository.Impl.TaskRepositoryImpl;
import peaksoft.repository.TaskRepository;
import peaksoft.service.TaskService;

import java.util.List;


public class TaskServiceImpl implements TaskService {
TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public void saveTask(Long lessonId, Task task) {
taskRepository.saveTask(lessonId, task);
    }

    @Override
    public void updateTask(Long id, Task task) {
taskRepository.updateTask(id, task);
    }

    @Override
    public List<Task> getAllTasksByLessonId(Long id) {
        return taskRepository.getAllTaskLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
taskRepository.deleteTaskById(id);
    }
}
