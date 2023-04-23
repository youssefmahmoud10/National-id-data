package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.NationalIdDataResponse;
import com.example.demo.models.NationalIdRequest;
import com.example.demo.services.NationalIdDataService;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:28:33 PM
 */

@RestController
@RequestMapping("nationalIdDataController") //http://localhost:8080/nationalIdDataController/getNationalIdData
public class NationalIdDataController {

	@Autowired
	private NationalIdDataService nationalIdDataService;

	@CrossOrigin
	@PostMapping(path = "/getNationalIdData")
	public NationalIdDataResponse getNationalIdData(@RequestBody NationalIdRequest nationalIdRequest) {
		return nationalIdDataService.getNationalIdData(nationalIdRequest);
	}

}