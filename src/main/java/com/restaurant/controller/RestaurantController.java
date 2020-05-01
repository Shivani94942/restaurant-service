package com.restaurant.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.error.ErrorMessage;
import com.restaurant.error.IdNotFoundException;
import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RestaurantController {
	
	
	private RestaurantService restaurantService;
	
	
	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}
	@ExceptionHandler
	  public ResponseEntity<ErrorMessage> handleError1(IdNotFoundException infe) 
	  {
		  ErrorMessage errorMessage=new ErrorMessage();
		  errorMessage.setMessage(infe.getMessage());
		  errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		  errorMessage.setErrorTime(LocalDateTime.now());
		  return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	  }
	@ExceptionHandler
	  public ResponseEntity<ErrorMessage> handleError2(Exception e) 
	  {
		  ErrorMessage errorMessage=new ErrorMessage();
		  errorMessage.setMessage(e.getMessage());
		  errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		  errorMessage.setErrorTime(LocalDateTime.now());
		  return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	  }
	  
	
	
	@ApiOperation(value = "Create a restaurant")
	@PostMapping("/restaurant/")
	public ResponseEntity<Restaurant> createRestaurant(@Valid@RequestBody Restaurant restaurant)
	{
		restaurantService.createRestaurant(restaurant);
		
		 return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retrieve the restaurant details",response = Restaurant.class)
	@GetMapping("/restaurant/{id}")
	public Restaurant getRestaurantById(@PathVariable Integer id){
		
		//return restaurantService.getRestaurantById(id);
		if(restaurantService.getRestaurantById(id)==null)
			
		{
			throw new IdNotFoundException("The id is not found : "+id);
		}
		
	return restaurantService.getRestaurantById(id);
	}
	
	@ApiOperation(value = "Update the restaurant details")
	@PutMapping("/restaurant/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable Integer id) {
		
		Restaurant rest = null;
		if(restaurantService.getRestaurantById(id)==null) {
			throw new IdNotFoundException("The id is not found : "+id);
		}
		else {
			 rest = restaurantService.createRestaurant(restaurant);
		}
		
		return rest;
	}
	
	@ApiOperation(value = "Remove the restaurant details")
	@DeleteMapping("/restaurant/{id}")
	public void deleteRestaurantById(@PathVariable Integer id) {
		
		
		if(restaurantService.getRestaurantById(id)==null) {
			throw new IdNotFoundException("The id is not found : "+id);
		}
		else {	
		restaurantService.deleteRestaurantById(id);
		}
	}
	

}
