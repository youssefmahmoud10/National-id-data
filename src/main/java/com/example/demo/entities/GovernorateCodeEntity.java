package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:16:49 PM
 */

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "GOVERNORATE_CODE")
public class GovernorateCodeEntity {

	@Column(name = "CODE")
	@Id
	Integer code;

	@Column(name = "NAME")
	String name;

}