package com.sample.coinchange.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sample.coinchange.dao.CoinRepository;
import com.sample.coinchange.dto.CoinType;
import com.sample.coinchange.entity.Coin;

@ExtendWith(MockitoExtension.class)
public class CoinInventoryServiceImplTest {
	
	@Mock
	private CoinRepository coinRepositoryMock;
	
	@InjectMocks
	private CoinInventoryServiceImpl coinInventoryServiceImpl;
	
	
	@Test
	public void retrieveCoinInventoryByIdTest() {
		when(coinRepositoryMock.findById(1)).thenReturn(Optional.of(new Coin(1, CoinType.QUARTER, 100)));
		assertThat(coinInventoryServiceImpl.retrieveCoinInventoryById(1).getQuantity()).isEqualTo(100);
	}
	

}
