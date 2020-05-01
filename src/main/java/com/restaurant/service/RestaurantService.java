package com.restaurant.service;

import com.restaurant.model.Restaurant;


public interface RestaurantService {
	
	public Restaurant createRestaurant(Restaurant restaurant);
	
	public Restaurant getRestaurantById(Integer id);
	
	public void deleteRestaurantById(Integer id);

}
