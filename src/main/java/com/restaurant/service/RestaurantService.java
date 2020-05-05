package com.restaurant.service;

import java.util.Optional;

import com.restaurant.model.Restaurant;


public interface RestaurantService {
	
	public Restaurant createRestaurant(Restaurant restaurant);
	
	public Optional<Restaurant> getRestaurantById(Integer id);
	
	public void deleteRestaurantById(Integer id);

}
