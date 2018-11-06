package test;

/*
 * Testing the functionalities of the person class
 * 
 * No need to test setters and getters as we know they work
 */

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import main.Person;

public class PersonTest {

	@Test
	public void testToString() {
		
		Person person = new Person("Zach", "9782907148", "z_rich@salemstate.edu");
		String expected = "[" + person.getName() + ", "  + person.getTelephoneNum() + ", " + person.getEmail() + "]";
		Assert.assertEquals(expected, person.toString());
		
	}

}
