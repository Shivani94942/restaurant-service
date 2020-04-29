package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RestaurantDao;
import com.example.demo.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantDao restaurantDao;
	
	@Autowired
	public RestaurantServiceImpl(RestaurantDao restaurantDao) {
		super();
		this.restaurantDao = restaurantDao;
	}

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
		return restaurantDao.save(restaurant);
	}

	@Override
	public Optional<Restaurant> getRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		return restaurantDao.findById(id);
	}

	@Override
	public void deleteRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		restaurantDao.deleteById(id);

	}

}
