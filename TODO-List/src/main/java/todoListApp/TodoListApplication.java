package todoListApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}

// For Application login, check todoListApp.security.SecurityConfig class
// for registered users
// Public Access --> (/)
// User1 --> (/user) username: foo, password: bar, role: user
// User2 --> (/user/admin) username: admin, password: admin, role: user, admin
