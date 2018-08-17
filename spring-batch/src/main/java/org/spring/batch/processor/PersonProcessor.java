package org.spring.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.batch.entity.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonProcessor implements ItemProcessor<Person, Person>{
	
	public static final Logger log = LoggerFactory.getLogger(PersonProcessor.class);

	@Override
	public Person process(Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
	}

	
	
}
