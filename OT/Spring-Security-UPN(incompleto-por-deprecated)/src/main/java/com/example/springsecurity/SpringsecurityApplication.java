package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}


	/*@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner createPasswordCommand(){
		return args -> {
			System.out.println(passwordEncoder.encode("clave1234"));
			System.out.println(passwordEncoder.encode("clave567"));
			System.out.println(passwordEncoder.encode("clave8910"));
		};
	}*/
}
