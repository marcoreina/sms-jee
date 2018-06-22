package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.reina.marco.sms.domain.Person;
import com.reina.marco.sms.domain.User;
import com.reina.marco.sms.service.PersonService;
import com.reina.marco.sms.service.UserService;

public class PersonServiceTest {
	
	private PersonService personService;
        private UserService userService;
        
        EJBContainer container;
	
	@Before
	public void setup() throws NamingException {
		container = EJBContainer.createEJBContainer();
                System.out.println("Opening the Glassfish embedded container");
		personService = (PersonService)container.getContext()
				.lookup("java:global/classes/PersonServiceImpl!com.reina.marco.sms.service.PersonService");
                userService = (UserService)container.getContext()
				.lookup("java:global/classes/UserServiceImpl!com.reina.marco.sms.service.UserService");
	}
        
        @Test
        public void testEJB() {
            this.testEJBPersonService();
            this.testEJBUserService();
        }

	@Test
	public void testEJBPersonService() {
		System.out.println("Initializing EJB PersonService test");
		assertTrue(personService != null);
		
		assertEquals(2, personService.listPersons().size());
		
		System.out.println("The number of persons is equal to: " + personService.listPersons().size());
		
		this.printPersons(personService.listPersons());
		System.out.println("Ending EJB PersonService test");
	}
        
        @Test
	public void testEJBUserService() {
		System.out.println("Initializing EJB UserService test");
		assertTrue(userService != null);
		
		assertEquals(1, userService.listUsers().size());
		
		System.out.println("The number of users is equal to: " + userService.listUsers().size());
		
		this.printUsers(userService.listUsers());
		System.out.println("Ending EJB UserService test");
	}
	
	private void printPersons(List<Person> persons) {
		for(Person person: persons) {
			System.out.println(person);
		}
	}
        
        private void printUsers(List<User> users) {
		for(User user: users) {
			System.out.println(user);
		}
	}
}
