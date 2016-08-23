package com.aep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aep.dao.PersonDao;
import com.aep.domain.Person;

@Service
/**
 * 
 * @author emrah.pekesen
 *
 */
public class PersonService {

	@Autowired
	PersonDao personDao;

	public boolean save(Person person) {
		if (person.getId() > 0) {
			personDao.insert(person);
			return true;
		} else
			return false;
	}

	public Person getById(Long id) {
		return personDao.getById(id);
	}
	
	public List<Person> getAll() {
		return personDao.getAll();
	}
	
	public void deleteById(Long id){
		personDao.deleteById(id);
	}
	
	public boolean update(Person person){
		if (person.getId() > 0) {
			personDao.update(person);
			return true;
		} else
			return false;
	}

}
