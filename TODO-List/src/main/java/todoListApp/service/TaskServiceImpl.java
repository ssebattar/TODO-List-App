package todoListApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoListApp.model.Task;
import todoListApp.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(long id) {
		Task task;
		
		// This class check to see if task exist
		Optional<Task> optionalTask = taskRepository.findById(id);
		task = optionalTask.get();
		
		return task;
	}

	@Override
	public void saveTask(Task task) {
		this.taskRepository.save(task);
	}

	@Override
	public void deleteTaskById(long id) {
		taskRepository.deleteById(id);
	}

}
