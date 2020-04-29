package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Restaurant;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant, Integer>
{	
	public Optional<Restaurant> getRestaurantById(Integer id);
}
