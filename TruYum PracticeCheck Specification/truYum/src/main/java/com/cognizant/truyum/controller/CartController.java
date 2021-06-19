package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService service;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		service.addCartItem(userId, menuItemId);
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException {
		return service.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		service.removeCartItem(userId, menuItemId);
	}

}
