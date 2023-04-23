package com.example.demo.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:22:39 PM
 */

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NationalIdRequest {
	String nationalId;
}