package com.sample.coinchange.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.coinchange.dao.CoinRepository;
import com.sample.coinchange.dto.CoinChangeResponse;
import com.sample.coinchange.dto.CoinType;
import com.sample.coinchange.entity.Coin;
import com.sample.coinchange.exception.InsufficientCoinsException;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoinChangeServiceImpl implements CoinChangeService{
	
//	@Autowired
//	private CoinInventoryDao coinInventoryDao;
	
	@Autowired
	private CoinRepository coinRepository;

	@Transactional
    public List<CoinChangeResponse> getChange(Integer bill) throws InsufficientCoinsException {
        List<CoinChangeResponse> coinChangeList = new LinkedList<>();
        log.info("Get change for bill -> {}", bill);
        // Calculate required change
        BigDecimal remainingAmount = BigDecimal.valueOf(bill);
        List<CoinType> coinValueList = CoinType.getSortedCoins(); // Sorted coins based on denomination in descending order

        for (CoinType coinValue : coinValueList) {
            int numCoinsNeeded = remainingAmount.divide(coinValue.getAmount(),0, RoundingMode.DOWN).intValue() ;
            //int availableCoins = coinInventoryDao.getCoin(coinValue).getQuantity();
            Coin coin = coinRepository.findByDenomination(coinValue);
            int availableCoins = coin.getQuantity();
            // Only take as many coins as available
            int coinsToGive = Math.min(numCoinsNeeded, availableCoins);
            
            if (coinsToGive > 0) {
            	CoinChangeResponse coinChangeResponse  = new CoinChangeResponse();
            	coinChangeResponse.setCoins(coinsToGive);
            	coinChangeResponse.setCoinType(coinValue);
                coinChangeList.add(coinChangeResponse);
                remainingAmount = remainingAmount.subtract(coinValue.getAmount().multiply(BigDecimal.valueOf(coinsToGive)));
                //coinInventoryDao.getCoin(coinValue).setQuantity(availableCoins - coinsToGive);
                coin.setQuantity(availableCoins - coinsToGive);
                coinRepository.save(coin);
            }
        }

        // If the remaining amount isn't 0, it means we couldn't make exact change
        if (remainingAmount.compareTo(BigDecimal.valueOf(0)) > 0) {
            throw new InsufficientCoinsException("Not enough coins to make change for $" + bill + " with remaining amount of " + remainingAmount);
        }

        return coinChangeList;
    }

}
