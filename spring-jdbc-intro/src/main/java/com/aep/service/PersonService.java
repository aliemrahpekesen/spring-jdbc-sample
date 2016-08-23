package com.aep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aep.dao.PersonDao;
import com.aep.model.Person;

@Service
/**
 * 
 * @author emrah.pekesen
 *
 */
public class PersonService {

	@Autowired
	PersonDao personDao;

	public String save(Person person) {
		personDao.save(person);
		return "Person successfully saved!";
	}

}
