package com.aep.domain.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aep.domain.Person;

/**
 * 
 * @author emrah.pekesen
 * 
 *         Maps Person Entity Data to Person Model.
 *
 */
public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong(1)); // index based mapping
		person.setName(rs.getString(2));
		person.setSurname(rs.getString("surname")); // column name based mapping
		return person;
	}

}
