package jp.springbook.springmyapp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private boolean onlyNumber = false;
	
	public void initialize(Phone phone) {
		onlyNumber = phone.onlyNumber();
	}

	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (input == null) {
			return false;
		}
		if (onlyNumber) {
			return input.matches("[0-9]*");
		} else {
			return input.matches("[0-9()-]*");
		}
	}

}
