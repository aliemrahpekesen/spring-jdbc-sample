package com.aep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.aep.domain.Person;
import com.aep.domain.row.mapper.PersonRowMapper;

@Component
/**
 * 
 * @author emrah.pekesen
 *
 */
public class PersonDao {

	/**
	 * Queries
	 */
	private static final String CREATE_TABLE = "create table TMP_PERSON\n" + "(\n" + "  id      NUMBER,\n"
			+ "  name    VARCHAR2(250),\n" + "  surname VARCHAR2(255)\n" + ")";

	private static final String CREATE = "insert into TMP_PERSON(id,name,surname) values(?,?,?)";
	private static String RETRIEVE_BY_ID = "select * from TMP_PERSON where id = ?";
	private static final String RETRIEVE_ALL = "select * from TMP_PERSON";
	private static final String UPDATE = "update Tmp_Person set name = ?, surname = ? where id = ?";
	private static final String DELETE_BY_ID = "delete from TMP_PERSON where id = ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Person person) {
		jdbcTemplate.update(CREATE, new Object[] { person.getId(), person.getName(), person.getSurname() });
	}

	public Person getById(Long id) {
		return jdbcTemplate.queryForObject(RETRIEVE_BY_ID, new Object[] { id }, new PersonRowMapper());
	}

	public List<Person> getAll() {
		return jdbcTemplate.query(RETRIEVE_ALL, new PersonRowMapper());
	}

	public void deleteById(Long id) {
		jdbcTemplate.update(DELETE_BY_ID, new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setLong(1, id);
			}
		});
	}

	public void update(Person person) {
		PreparedStatementCreator pscForPersonUpdate = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement updatePerson = conn.prepareStatement(UPDATE);
				updatePerson.setString(1, person.getName());
				updatePerson.setString(2, person.getSurname());
				updatePerson.setLong(3, person.getId());
				return updatePerson;
			}
		};

		jdbcTemplate.update(pscForPersonUpdate);
	}

	public void createTable() {
		jdbcTemplate.execute(CREATE_TABLE);
	}

}
