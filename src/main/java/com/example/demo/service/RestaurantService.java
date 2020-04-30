package com.example.demo.service;

import com.example.demo.model.Restaurant;


public interface RestaurantService {
	
	public Restaurant createRestaurant(Restaurant restaurant);
	
	public Restaurant getRestaurantById(Integer id);
	
	public void deleteRestaurantById(Integer id);

}
