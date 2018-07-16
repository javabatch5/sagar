package com.facebook.validation;

public class Validation {
public boolean nullcheck(String text){
	if(text==null){
		System.out.println("Enetered into nullcheck :: validation");
		return true;
	}
	System.out.println("Exiting from nullcheck :: validation ");
	return false;
}
}
