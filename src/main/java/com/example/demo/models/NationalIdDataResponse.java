package com.example.demo.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:24:22 PM
 */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NationalIdDataResponse {

	String message;
	String centuryOfBirth;
	String yearOfBirth;
	String monthOfBirth;
	String dayOfBirth;
	String governorate;
	String order;
	String gender;

}