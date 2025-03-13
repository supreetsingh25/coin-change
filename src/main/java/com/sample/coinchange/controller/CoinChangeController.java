package com.sample.coinchange.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.coinchange.dto.CoinChangeResponse;
import com.sample.coinchange.exception.InvalidBillAmountException;
import com.sample.coinchange.service.CoinChangeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CoinChangeController {

	@Autowired
	private CoinChangeService coinChangeService;

	@GetMapping(value = "/api/change/{bill}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CoinChangeResponse> calculateChange(@PathVariable Integer bill) {
		log.info("Calculating change for {}", bill);

		List<Integer> validBills = Arrays.asList(1, 2, 5, 10, 20, 50, 100);

		if (!validBills.contains(bill)) {
			throw new InvalidBillAmountException("Invalid bill amount. Accepted bills: 1, 2, 5, 10, 20, 50, 100.");
		}
		return coinChangeService.getChange(bill);
	}
}
