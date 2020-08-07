package todoListApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todoListApp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
