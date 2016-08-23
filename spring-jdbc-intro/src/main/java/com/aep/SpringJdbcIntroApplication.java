package com.aep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aep.model.Person;
import com.aep.service.PersonService;

@SpringBootApplication
/**
 * 
 * @author emrah.pekesen
 *
 */
public class SpringJdbcIntroApplication {

	@Autowired
	PersonService personService;

	@PostConstruct
	public void doSomething() {
		Person person = new Person(1001L, "Emrah", "PEKESEN", 30);
		String resultMessage = personService.save(person);
		System.out.println(resultMessage);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcIntroApplication.class, args);
	}

}
