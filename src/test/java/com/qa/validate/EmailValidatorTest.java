package com.qa.validate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// try and make sure test classes start or end with 'Test'
public class EmailValidatorTest {

	@Test
	public void testNoAddress() {
		assertFalse(EmailValidator.validateEmail("@qa.com"));
	}

	@Test
	public void testNoDomain() {
		assertFalse(EmailValidator.validateEmail("jordan@"));
	}

	@Test
	public void testInvalidDomain() {
		assertFalse(EmailValidator.validateEmail("jordan.harrison@hotmail.co.uk"));
	}

	@Test
	public void testValidDomainGmail() {
		assertTrue(EmailValidator.validateEmail("jordan.harrison@gmail.com"));
	}

	@Test
	public void testDomainQA() {
		assertTrue(EmailValidator.validateEmail("jordan.harrison@qa.com"));
	}

	@Test
	public void testStartsWithLetterOrNumber() {
		assertFalse(EmailValidator.validateEmail("_jordan.harrison@qa.com"));
	}

	@Test
	public void testContainsAt() {
		assertFalse(EmailValidator.validateEmail("jordan.harrison.qa.com"));
	}
}
