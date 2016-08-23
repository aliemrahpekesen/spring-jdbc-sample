package com.aep.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.aep.model.Person;

@Component
/**
 * 
 * @author emrah.pekesen
 *
 */
public class PersonDao {

	private static final String INSERT_PERSON = "insert into Person(id,name,surname,age) values(?,?,?,?)";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void save(Person person) {
		jdbcTemplate.update(INSERT_PERSON,
				new Object[] { person.getId(), person.getName(), person.getSurname(), person.getAge() });
	}

}
