package com.floobyte.franchise;

import com.floobyte.franchise.model.USER_ROLE;
import com.floobyte.franchise.model.User;
import com.floobyte.franchise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FranchiseApplication {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(FranchiseApplication.class, args);
	}

	public void run(String... args) {
		User adminAccount = userRepository.findByRole(USER_ROLE.ROLE_ADMIN);
		if (null == adminAccount) {
			User user = new User();
			user.setEmail("pravegpachpute@gmail.com");
			user.setFullName("Praveg Sanjay Pachpute");
			user.setRole(USER_ROLE.ROLE_ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("Praveg@1010"));
			userRepository.save(user);
		}
	}
}
