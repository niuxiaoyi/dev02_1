package com.fc.controller;

import com.fc.service.Item;
import com.fc.service.Packing;
import com.fc.service.impl.Bottle;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
    @Override
    public abstract float price();
}