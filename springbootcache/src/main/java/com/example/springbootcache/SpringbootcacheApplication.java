package com.example.springbootcache;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.ControllerPerson;

@SpringBootApplication
@EnableCaching
//@CacheEvict             used to remove cache
//@CacheConfig            used to set configuration for cache
//@CachePut               used to update cache
//@Cacheable              used to group cache
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.controller,com.example.service")
public class SpringbootcacheApplication implements CommandLineRunner {

	
	@Autowired
	public ControllerPerson controllerPerson;
	
	private static final Logger logger= org.slf4j.LoggerFactory.getLogger(SpringbootcacheApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Featching Data For Person");
		logger.info("First Person ->"+controllerPerson.getPersonData());
		logger.info("Second Person ->"+controllerPerson.getPersonData());
		logger.info("Third Person ->"+controllerPerson.getPersonData());
		logger.info("Fourth Person ->"+controllerPerson.getPersonData());
		logger.info("Fifth Person ->"+controllerPerson.getPersonData());
		logger.info("Sixth Persong ->"+controllerPerson.getPersonData());
	}
}
