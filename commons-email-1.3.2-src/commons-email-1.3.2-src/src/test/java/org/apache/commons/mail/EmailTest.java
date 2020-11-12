package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	private static final String[] TEST_EMAILS = { "qwertyuiop@xyz.com", "mnbqwe@troll.net", "qazxswedc@poiuy.org",
	"asd123@asdf.com.bd"};
	
	private static final String TEST_NAME = "Name";
	private static final String TEST_HEADER_VALUE = "Value";
	
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
	
	@Test
	public void testAddHeader() throws Exception {
		
		email.addHeader(TEST_NAME, TEST_HEADER_VALUE);
		
		assertEquals(TEST_HEADER_VALUE, email.headers.get(TEST_NAME));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test2AddHeader() throws Exception {
		
		email.addHeader("", TEST_HEADER_VALUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test3AddHeader() throws Exception {
		
		email.addHeader(TEST_NAME, "");
	}
}
