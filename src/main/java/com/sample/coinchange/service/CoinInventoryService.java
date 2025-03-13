package com.sample.coinchange.service;

import java.util.List;

import com.sample.coinchange.entity.Coin;

public interface CoinInventoryService {
	List<Coin> retrieveCoinInventory();

	Coin retrieveCoinInventoryById(Integer id);

	Coin createCoinInventory(Coin coin);
}
