package com.onlinestore.service;

import org.springframework.stereotype.Service;

import com.onlinestore.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
	}
}
