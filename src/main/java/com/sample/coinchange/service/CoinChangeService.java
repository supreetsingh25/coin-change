package com.sample.coinchange.service;

import java.util.List;

import com.sample.coinchange.dto.CoinChangeResponse;
import com.sample.coinchange.exception.InsufficientCoinsException;

public interface CoinChangeService {
	List<CoinChangeResponse> getChange(Integer bill) throws InsufficientCoinsException;
}
