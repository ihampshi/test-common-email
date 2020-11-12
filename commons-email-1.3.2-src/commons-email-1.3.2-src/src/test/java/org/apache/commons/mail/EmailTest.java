package org.apache.commons.mail;

import org.junit.After;
import org.junit.Before;

public class EmailTest {

	//Concrete email instance for testing
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
		
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		
	}
}
