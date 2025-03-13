package com.sample.coinchange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.coinchange.dao.CoinRepository;
import com.sample.coinchange.entity.Coin;
import com.sample.coinchange.exception.CoinNotFoundException;

@Service
public class CoinInventoryServiceImpl implements CoinInventoryService{
	
	@Autowired
	private CoinRepository coinRepository;
	
	public List<Coin> retrieveCoinInventory() {
		return coinRepository.findAll();
	}

	@Override
	public Coin retrieveCoinInventoryById(Integer id) {
		Optional<Coin> optional = coinRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new CoinNotFoundException("Coin with id -> "+ id + " is not present. ");
		}
	}

	@Override
	public Coin createCoinInventory(Coin coin) {
		Coin byDenomination = coinRepository.findByDenomination(coin.getDenomination());
		if(byDenomination != null) {
			byDenomination.setQuantity(coin.getQuantity());
			return coinRepository.save(byDenomination);
		}else {
			return coinRepository.save(coin);
		}
	}

}
