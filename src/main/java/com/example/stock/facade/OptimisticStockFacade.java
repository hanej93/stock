package com.example.stock.facade;

import org.springframework.stereotype.Service;

import com.example.stock.service.OptimisticLockStockService;

@Service
public class OptimisticStockFacade {

	private OptimisticLockStockService optimisticLockStockService;

	public OptimisticStockFacade(OptimisticLockStockService optimisticLockStockService) {
		this.optimisticLockStockService = optimisticLockStockService;
	}

	public void decrease(Long id, Long quantity) throws InterruptedException {
		while (true) {
			try {
				optimisticLockStockService.decrease(id, quantity);
				break;
			} catch (Exception e) {
				Thread.sleep(50);
			}
		}
	}

}
