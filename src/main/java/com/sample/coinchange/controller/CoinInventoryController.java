package com.sample.coinchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.coinchange.entity.Coin;
import com.sample.coinchange.service.CoinInventoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CoinInventoryController {
	
	@Autowired
	private CoinInventoryService coinInventoryService;

	@GetMapping(value = "/api/coin/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Coin> retrieveCoinInventory() {
		log.info("Retrieve Coin Inventory ");
		return coinInventoryService.retrieveCoinInventory();
	}
	
	@GetMapping(value = "/api/coin/inventory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Coin retrieveCoinInventoryById(@PathVariable Integer id) {
		log.info("Retrieve Coin Inventory by Id -> {}", id);
		return coinInventoryService.retrieveCoinInventoryById(id);
	}
	
	@PostMapping(value = "/api/coin/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
	public Coin createCoinInventory(@RequestBody Coin coin) {
		log.info("Create Coin Inventory ");
		return coinInventoryService.createCoinInventory(coin);
	}

}
