package com.testing.sender.springsenderapp.dto;

import com.testing.sender.springsenderapp.model.Swift;

public class SwiftMapper {

	public static Swift convertToSwift(SwiftDto swiftDto) {

		String swiftCode = swiftDto.getSwiftCode().toUpperCase();
		
		String bank = swiftCode.substring(0, 4);
		String location = swiftCode.substring(6, 8);
		String country = swiftCode.substring(4, 6);

		String branch = "";
		if (swiftCode.length() == 11) {
			branch = swiftDto.getSwiftCode().substring(8, 11);
		}

		Swift swift = new Swift(bank, country, location, branch);

		return swift;
	}
}
