package com.sample.coinchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.coinchange.dto.CoinType;
import com.sample.coinchange.entity.Coin;

public interface CoinRepository extends JpaRepository<Coin, Integer>{

	Coin findByDenomination(CoinType coinValue);

}
