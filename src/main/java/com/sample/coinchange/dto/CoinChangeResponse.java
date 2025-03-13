package com.sample.coinchange.dto;

import lombok.Data;

@Data
public class CoinChangeResponse {
	
	private CoinType coinType;
	private Integer coins;

}
