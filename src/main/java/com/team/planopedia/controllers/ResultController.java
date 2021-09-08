package com.team.planopedia.controllers;

import com.team.planopedia.modelsAndServices.restaurant.Restaurant;
import com.team.planopedia.modelsAndServices.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {
    
    @Autowired
    RestaurantService restaurantService;
    
    @GetMapping("/result")
    public String result(Model model,
                         @RequestParam("city") String city,                 //This variables are obtained via GET request from form page.
                         @RequestParam("zipcode") String zipcode,
                         @RequestParam("cuisine") String cuisine,
                         @RequestParam("numpeople") String numPeople)
    {


        Restaurant restaurant = restaurantService.generateRestaurant(city, zipcode, cuisine, Integer.parseInt(numPeople));

        System.out.println(city);
        System.out.println(zipcode);
        System.out.println(cuisine);
        System.out.println(numPeople);


        model.addAttribute("restaurant",restaurant);   //adding the Restaurant object to a model which is accessible in the HTML pages.
        
        return "result";
    }
}
