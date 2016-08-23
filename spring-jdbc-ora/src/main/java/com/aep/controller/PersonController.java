package com.aep.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aep.domain.Person;
import com.aep.service.PersonService;

@Controller
/**
 * 
 * @author emrah.pekesen
 *
 */
public class PersonController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonService personService;

	@RequestMapping("/checkService")
	public @ResponseBody String checkService() {
		return "It is up and running properly!";
	}

	/**
	 * 
	 * @param person
	 *            ex. : { "id":1500, "name":"Emrah", "surname":"PEKESEN" }
	 * @return
	 */
	@RequestMapping(path = "/person/create", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody Person person) {
		if (personService.save(person))
			return "Successfully Saved!";
		else {
			logger.warn("One of Person Creation Request is falied. Please find Person Details in below..");
			logger.warn("Person ID       : " + person.getId());
			logger.warn("Person Name     : " + person.getName());
			logger.warn("Person Surname  : " + person.getSurname());
			return "Creation Failed";
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "person/{id}", method = RequestMethod.GET)
	public @ResponseBody Person retrieveById(@PathVariable("id") Long id) {
		return personService.getById(id);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(path = "person/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Person> retrieveAll() {
		return personService.getAll();
	}

	/**
	 * 
	 * @param person
	 *            ex. : { "id":1500, "name":"Emrah", "surname":"PEKESEN" }
	 * @return
	 */
	@RequestMapping(path = "/person/update", method = RequestMethod.PUT)
	public @ResponseBody String update(@RequestBody Person person) {
		if (personService.update(person))
			return "Successfully Updated!";
		else {
			logger.warn("One of Person Update Request is falied. Please find Person Details in below..");
			logger.warn("Person ID       : " + person.getId());
			logger.warn("Person Name     : " + person.getName());
			logger.warn("Person Surname  : " + person.getSurname());
			return "Update Failed";
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "person/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") Long id) {
		personService.deleteById(id);
		return "Successfully Deleted";
	}
}
