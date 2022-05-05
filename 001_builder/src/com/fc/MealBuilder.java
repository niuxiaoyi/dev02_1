package com.fc;

import com.fc.dao.ChickenBurger;
import com.fc.dao.Coke;
import com.fc.dao.Pepsi;
import com.fc.dao.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
