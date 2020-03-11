package com.example.jpa.SpringJpa;

import com.example.jpa.SpringJpa.Exception.UserAlreadyExistException;
import com.example.jpa.SpringJpa.Service.UserService;
import com.example.jpa.SpringJpa.bean.User;
import com.example.jpa.SpringJpa.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {
//	private static final Logger log= LoggerFactory.getLogger(SpringJpaApplication.class);
	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);




	}

	@Bean
	public CommandLineRunner demo (UserRepository repository){
		return (args)->{
			repository.save(new User ("Antoine", "Vigueur-Fontana", "pitoine@hotmail.com", "deretour8"));
			repository.save(new User("Sasha", "Lambert", "sashou@caramail.io", "kikou4"));
			System.out.println("_____________________________________________________________________");
			List<User> userList=repository.findByLastName("Lambert");
			for(User u: userList){
				System.out.println("User : " + u.getId() + "\nFirstname : " + u.getFirstName() + "\nLastname : " + u.getLastName() + "\nEmail : " + u.getEmail() + "\nPassword = " + u.getPassword());
			}
			System.out.println("_____________________________________________________________________");
			User email=repository.getUserByEmail("pitoine@hotmail.com");

				System.out.println("User : " + email.getId() + "\nFirstname : " + email.getFirstName() + "\nLastname : " + email.getLastName() + "\nEmail : " + email.getEmail() + "\nPassword = " + email.getPassword());
//			System.out.println("_____________________________________________________________________");
//			try{
//				UserService userService=new UserService();
//				userService.register("moi@remoi.moi", "coucou");
//			}catch (UserAlreadyExistException e) {
//				e.getMessage();
//			}

		};
	}
}
