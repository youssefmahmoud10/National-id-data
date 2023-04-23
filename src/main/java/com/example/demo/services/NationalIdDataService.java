package com.example.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.NationalIdDataResponse;
import com.example.demo.models.NationalIdRequest;
import com.example.demo.repositories.GovernorateCodeRepository;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:30:12 PM
 */

@Service
public class NationalIdDataService {

	@Autowired
	private GovernorateCodeRepository governorateCodeRepository;

	public boolean isValidNationalIdInput(NationalIdRequest nationalIdRequest) {
		return Pattern.compile("^\\d{14}$").matcher(nationalIdRequest.getNationalId()).find();
	}

	public boolean isValidDate(String date) {
		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern("uu-M-d").withResolverStyle(ResolverStyle.STRICT));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public int centuryFromYear(String year) {
		if (Integer.parseInt(year) % 100 == 0)
			return Integer.parseInt(year) / 100;
		else
			return (Integer.parseInt(year) / 100) + 1;
	}

	public boolean isValidCentury(String year) {
		return centuryFromYear(year) <= centuryFromYear(Integer.toString(LocalDate.now().getYear()));
	}

	public NationalIdDataResponse getNationalIdData(NationalIdRequest nationalIdRequest) {
		NationalIdDataResponse nationalIdDataResponse = new NationalIdDataResponse();
		if (isValidNationalIdInput(nationalIdRequest)) {
			Pattern pattern = Pattern
					.compile("^([1-9])(\\d{2})(\\d{2})(\\d{2})(0[1-4]|[12][1-9]|3[1-5]|88)(\\d{4})([1-9])$");
			Matcher matcher = pattern.matcher(nationalIdRequest.getNationalId());
			if (matcher.find() && isValidDate(matcher.group(2) + "-" + matcher.group(3) + "-" + matcher.group(4))
					&& isValidCentury(Integer.toString(17 + Integer.parseInt(matcher.group(1))) + matcher.group(2))) {
				nationalIdDataResponse.setMessage("Valid national id.");
				nationalIdDataResponse.setCenturyOfBirth(matcher.group(1));
				nationalIdDataResponse
						.setYearOfBirth(Integer.toString(17 + Integer.parseInt(matcher.group(1))) + matcher.group(2));
				nationalIdDataResponse.setMonthOfBirth(matcher.group(3));
				nationalIdDataResponse.setDayOfBirth(matcher.group(4));
				nationalIdDataResponse.setGovernorate(
						governorateCodeRepository.findById(Integer.parseInt(matcher.group(5))).get().getName());
				nationalIdDataResponse.setOrder(matcher.group(6));
				nationalIdDataResponse.setGender(matcher.group(6).charAt(3) % 2 == 0 ? "female" : "male");
			} else {
				nationalIdDataResponse.setMessage("Invalid national id.");
			}
		} else {
			nationalIdDataResponse.setMessage("Invalid input, enter 14 digits only.");
		}
		return nationalIdDataResponse;
	}

}