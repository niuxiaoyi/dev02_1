package com.fc.controller;

import com.fc.service.Item;
import com.fc.service.Packing;
import com.fc.service.impl.Wrapper;

public abstract class Burger implements Item {
    @Override   public Packing packing() {
        return new Wrapper();
    }
    @Override
    public abstract float price();
}

