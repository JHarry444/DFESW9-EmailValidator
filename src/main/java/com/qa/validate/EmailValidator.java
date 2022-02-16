package com.qa.validate;

public class EmailValidator {

	public static Boolean validateEmail(String email) {

//		return email.matches("([a-z]|[A-Z]|[0-9])([\\w]*|[\\w]*\\.[\\w]+)@[\\w]+(\\.[\\w]+){1,2}");

		if (!email.contains("@"))
			return false;

		String[] addressAndDomain = email.split("@");

		if (addressAndDomain.length != 2 || addressAndDomain[0].isBlank() || addressAndDomain[1].isBlank())
			return false;

		String domain = addressAndDomain[1];
		if (!(domain.equals("gmail.com") || domain.equals("qa.com")))
			return false;

		String address = addressAndDomain[0];

		char firstChar = address.toCharArray()[0];

		if (firstChar == '!' || firstChar == '.' || firstChar == '_' || firstChar == '-') {
			return false;
		}

		return true;
	}

}
