package com.reina.marco.sms.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.reina.marco.sms.domain.Person;
import com.reina.marco.sms.eis.PersonDao;

@Stateless
public class PersonServiceImpl implements PersonServiceRemote, PersonService {
	
	@EJB
	private PersonDao personDao;

	@Override
	public List<Person> listPersons() {
		return personDao.findAllPersons();
	}

	@Override
	public Person findPersonById(Person person) {
		return personDao.findPersonById(person);
	}

	@Override
	public Person findPersonByEmail(Person person) {
		return personDao.findPersonByEmail(person);
	}

	@Override
	public void registerPerson(Person person) {
		personDao.insertPerson(person);
	}

	@Override
	public void modifyPerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	public void deletePerson(Person person) {
		personDao.deletePerson(person);
	}
}
