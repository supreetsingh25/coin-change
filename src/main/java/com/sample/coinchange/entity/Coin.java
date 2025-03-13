package com.sample.coinchange.entity;

import com.sample.coinchange.dto.CoinType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name= "coin_inventory")
public class Coin {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	private CoinType denomination;
	private int quantity;
	
	protected Coin() {}
	
}
