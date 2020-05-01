package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
		return restaurantDao.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		return restaurantDao.findById(id).get();
	}

	@Override
	public void deleteRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		restaurantDao.deleteById(id);

	}

}
