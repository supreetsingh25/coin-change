package com.sample.coinchange.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoinType {
    PENNY(new BigDecimal("0.01")),
    NICKEL(new BigDecimal("0.05")),
    DIME(new BigDecimal("0.10")),
    QUARTER(new BigDecimal("0.25")),
    DOLLAR(new BigDecimal("1.00"))
    ;

    //@JsonValue
    private final BigDecimal amount;
    
 // This will allow us to reverse the order while sorting
    public static List<CoinType> getSortedCoins() {
        List<CoinType> coinValueList = new ArrayList<>(Arrays.asList(CoinType.values()));
        coinValueList.sort((o1, o2) -> o2.getAmount().compareTo(o1.getAmount())); // Descending order
        return Stream.of(CoinType.values()).sorted((o1, o2) -> o2.getAmount().compareTo(o1.getAmount())).toList();
        //CoinType.values().stream().sort((o1, o2) -> o2.getAmount().compareTo(o1.getAmount())).toList();
        //return coinValueList;
    }
}
