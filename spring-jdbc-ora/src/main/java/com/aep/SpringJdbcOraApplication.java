package com.aep;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.aep.dao.PersonDao;

@SpringBootApplication
@EnableConfigurationProperties
/**
 * 
 * @author emrah.pekesen
 *
 */
public class SpringJdbcOraApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringJdbcOraApplication.class);

	@Autowired
	PersonDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcOraApplication.class, args);
		logger.info("Application is started.");
	}

	@PostConstruct
	public void createPersonTable() {
		// personDao.createTable();
	}
}
