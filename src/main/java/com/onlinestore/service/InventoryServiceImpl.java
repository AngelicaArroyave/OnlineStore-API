package com.onlinestore.service;

import org.springframework.stereotype.Service;

import com.onlinestore.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	
	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
}
