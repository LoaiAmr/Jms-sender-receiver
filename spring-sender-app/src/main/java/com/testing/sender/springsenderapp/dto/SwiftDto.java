package com.testing.sender.springsenderapp.dto;

public class SwiftDto {

	private String swiftCode;

	public SwiftDto() {
		super();
	}

	public SwiftDto(String swiftCode) {
		super();
		this.swiftCode = swiftCode;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	@Override
	public String toString() {
		return "SwiftDto [swiftCode=" + swiftCode + "]";
	}

}
