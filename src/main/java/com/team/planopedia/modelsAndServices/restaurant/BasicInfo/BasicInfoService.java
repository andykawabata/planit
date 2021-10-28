package com.team.planopedia.modelsAndServices.restaurant.BasicInfo;

import com.team.planopedia.API.adapters.RestaurantApiAdapter;
import com.team.planopedia.dao.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BasicInfoService {

    //yelpAPIAdapter apiAdapter = new yelpAPIAdapter;

    
    public BasicInfo chooseSingleRestaurant(String city, String zip, String cuisine, int numPeople, User user){
        
        RestaurantApiAdapter api = new RestaurantApiAdapter();
        int numRestaurants = 20;
        
        List<Map<String, String>> potentialRestaurants = api.getRestaurants(cuisine, city, numRestaurants);
        
        Map<String, String> chosenRestaurant = this.pickRandomRestaurantFromList(potentialRestaurants);
        
        String locationName = chosenRestaurant.get("restaurantName");
        String fullAddress = chosenRestaurant.get("address");
        String zipCode = chosenRestaurant.get("zipCode");
        String phoneNumber = chosenRestaurant.get("phoneNumber");
        String priceRating = chosenRestaurant.get("price");
        String starRating = chosenRestaurant.get("rating");
        String restaurantId = chosenRestaurant.get("restaurantID");
        String imageUrl = chosenRestaurant.get("image_url");

        return new BasicInfo(locationName, fullAddress, zipCode, phoneNumber, priceRating, starRating, restaurantId, imageUrl);

    }
    
    private Map<String, String> pickRandomRestaurantFromList(List<Map<String, String>> potentialRestaurants){
        
        return potentialRestaurants.get(0);
    }
    
}
