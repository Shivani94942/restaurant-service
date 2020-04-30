
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

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
	
	@ApiOperation(value = "Create a restaurant")
	@PostMapping("/restaurant/")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant)
	{
		Restaurant restra=restaurantService.createRestaurant(restaurant);
		
		return restra;
	}
	
	@ApiOperation(value = "Retrieve the restaurant details",response = Restaurant.class)
	@GetMapping("/restaurant/{id}")
	public Restaurant getRestaurantById(@PathVariable Integer id){
		
		return restaurantService.getRestaurantById(id);
	}
	
	@ApiOperation(value = "Update the restaurant details")
	@PutMapping("/restaurant/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable Integer id) {
		
		Restaurant rest = null;
		if(restaurantService.getRestaurantById(id)!=null) {
		 rest = restaurantService.createRestaurant(restaurant);
		}
		
		
		return rest;
	}
	
	@ApiOperation(value = "Remove the restaurant details")
	@DeleteMapping("/restaurant/{id}")
	public void deleteRestaurantById(@PathVariable Integer id) {
		
		if(restaurantService.getRestaurantById(id)!=null)
			restaurantService.deleteRestaurantById(id);
	}
	

}
