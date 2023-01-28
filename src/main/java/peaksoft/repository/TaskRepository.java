package peaksoft.repository;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskRepository {
    void saveTask (Long lesson_id, Task task);

    void updateTask(Long id ,Task task);

    List<Task> getAllTaskLessonId (Long lesson_id);

    void deleteTaskById(Long id);

}
