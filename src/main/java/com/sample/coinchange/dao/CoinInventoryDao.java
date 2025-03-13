package com.sample.coinchange.dao;

import static com.sample.coinchange.dto.CoinType.DIME;
import static com.sample.coinchange.dto.CoinType.NICKEL;
import static com.sample.coinchange.dto.CoinType.PENNY;
import static com.sample.coinchange.dto.CoinType.QUARTER;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sample.coinchange.dto.CoinType;
import com.sample.coinchange.entity.Coin;

@Component
public class CoinInventoryDao {
	private static Map<CoinType, Coin> coinInventory = new HashMap<>();
	
	private static int counter = 0;
	
	static {
		coinInventory.put(PENNY, new Coin(++counter, PENNY, 100));
        coinInventory.put(NICKEL, new Coin(++counter,NICKEL, 100));
        coinInventory.put(DIME, new Coin(++counter,DIME, 100));
        coinInventory.put(QUARTER, new Coin(++counter,QUARTER, 100));
	}
	
	
	public  Coin getCoin(CoinType coinType){
		return coinInventory.get(coinType);
	}

}
