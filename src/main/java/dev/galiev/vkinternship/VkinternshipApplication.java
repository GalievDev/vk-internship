package dev.galiev.vkinternship;

import dev.galiev.vkinternship.auth.RegisterRequest;
import dev.galiev.vkinternship.dao.user.Role;
import dev.galiev.vkinternship.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class VkinternshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkinternshipApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.name("Admin")
					.password("admin")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin access token: " + service.register(admin).getToken());

			var user = RegisterRequest.builder()
					.name("User")
					.password("users")
					.role(Role.USERS)
					.build();
			System.out.println("Users access token: " + service.register(user).getToken());

			var post = RegisterRequest.builder()
					.name("Post")
					.password("posts")
					.role(Role.POSTS)
					.build();
			System.out.println("Posts access token: " + service.register(post).getToken());

			var album = RegisterRequest.builder()
					.name("Album")
					.password("albums")
					.role(Role.ALBUMS)
					.build();
			System.out.println("Albums access token: " + service.register(album).getToken());
		};
	}
}
