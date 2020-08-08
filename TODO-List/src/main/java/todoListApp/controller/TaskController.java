package todoListApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import todoListApp.model.Task;
import todoListApp.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String todo(Model model) {
		model.addAttribute("tasklist", taskService.getAllTasks());
		
		return "tasks";
	}
	
	@GetMapping("/viewTask/{id}")
	public String viewTask(Model model, @PathVariable(value = "id") long id) {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		
		return "view_task";
	}
	
	@GetMapping("/addTask")
	public String addTask(Model model) {
		Task newTask = new Task();
		model.addAttribute("task", newTask);
		
		return "new_task";
	}
	
	@GetMapping("/editTask/{id}")
	public String editTask(Model model, @PathVariable(value = "id") long id) {
		
		//Get the existing task by its id
		Task thisTask = taskService.getTaskById(id);
		
		//Set the task to the model to pre-populate the form fields
		model.addAttribute("task", thisTask);
		
		return "edit_task";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task task) {
		// save attribute to the database
		taskService.saveTask(task);
		return "redirect:/";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable(value = "id") long id) {
		this.taskService.deleteTaskById(id);
		return "redirect:/";
	}

}
