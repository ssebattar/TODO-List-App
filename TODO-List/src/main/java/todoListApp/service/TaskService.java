package todoListApp.service;

import java.util.List;

import todoListApp.model.Task;

public interface TaskService {
	
	List<Task> getAllTasks();
	
	Task getTaskById(long id);
	
	void saveTask(Task task);
	
	void deleteTaskById(long id);

}
