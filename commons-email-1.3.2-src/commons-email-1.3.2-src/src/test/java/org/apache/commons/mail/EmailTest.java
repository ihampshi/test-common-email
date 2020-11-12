package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	private static final String[] TEST_EMAILS = { "qwertyuiop@xyz.com", "mnbqwe@troll.net", "qazxswedc@poiuy.org",
	"asd123@asdf.com.bd"};
	
	//Concrete email instance for testing
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
		
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		
	}
	
	@Test
	public void testAddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(4, email.getBccAddresses().size());
	}
	
	@Test
	public void test2AddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS[0]);
		
		assertEquals(1, email.getBccAddresses().size());
	}
	
	@Test(expected = EmailException.class)
	public void test3AddBcc() throws Exception {
		
		String[] empty = {};
		
		email.addBcc(empty);
	}
	
	@Test
	public void testAddCc() throws Exception {
		
		email.addCc(TEST_EMAILS);
		
		assertEquals(4, email.getCcAddresses().size());
	}
	
	@Test
	public void test2AddCc() throws Exception {
		
		email.addCc(TEST_EMAILS[0]);
		
		assertEquals(1, email.getCcAddresses().size());
	}
	
	@Test(expected = EmailException.class)
	public void test3AddCc() throws Exception {
		
		String[] empty = {};
		
		email.addCc(empty);
	}
}
