package com.testing.sender.springsenderapp.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.testing.sender.springsenderapp.exception.SwiftException;
import com.testing.sender.springsenderapp.model.CountryCode;

@Service
public class ValidationSwift {
	
	private static final Logger log = LoggerFactory.getLogger(ValidationSwift.class);
	
	private static  int SMALL_CODE = 8;
	private static int LARGE_CODE = 11;
	
	public static boolean checkValidateSwiftCode(String swiftCodeInput) {
		
		String swiftCode = swiftCodeInput.toUpperCase();
		
		if(isValidSwift(swiftCode)) {
			log.info("Invalid Swift Code!... " + swiftCode);
			throw new SwiftException("Invalid Swift Code!"); 
		}	
		
		String bank = swiftCodeInput.substring(0, 4);
		String location = swiftCodeInput.substring(6, 8);
		String country = swiftCodeInput.substring(4, 6);
		
		if(isValidBank(bank)) {
			log.info("Invalid Swift bank!... " + bank);
			throw new SwiftException("Invalid Bank!");
		}	
		if (isValidLocation(location)) {
			log.info("Invalid Swift location!... " + location);
			throw new SwiftException("Invalid Location!");
		}
		if (isValidCountry(country)) {
			log.info("Invalid Swift country!... " + country);
			throw new SwiftException("Invalid Swift Country!");
		}
		if(swiftCodeInput.length() == LARGE_CODE) {
			String branch = swiftCodeInput.substring(8, 11);
			if(isValidBranch(branch)) {
				log.info("Invalid Swift branch!... " + branch);
				throw new SwiftException("Invalid Branch!");
			}
		}
		
		return true; 
	}
	
	private static  boolean isValidSwift(String swiftCode) {
		if (swiftCode.length() == SMALL_CODE || swiftCode.length() == LARGE_CODE) {
			return false;
		} else
			return true;
	}
	
	private static  boolean isValidBank(String bank) {
		return !((!bank.equals("")) 
	            && (bank != null) 
	            && (bank.matches("^[a-zA-Z]{4}$")));
	}
	
	private static  boolean isValidLocation(String location) {
		return !((!location.equals("")) 
	            && (location != null) 
	            && (location.matches("^[A-Z0-9]{2}$")));
	}
	
	private static  boolean isValidBranch(String branch) {
		return !((!branch.equals("")) 
	            && (branch != null) 
	            && (branch.matches("^[A-Z0-9]{2}$")));
	}
	
	private static boolean isValidCountry(String country) {
		String[] countries = CountryCode.getCountries();
		return !(Arrays.asList(countries).contains(country));
	}
}
