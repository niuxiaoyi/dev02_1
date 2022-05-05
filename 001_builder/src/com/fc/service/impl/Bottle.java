package com.fc.service.impl;

import com.fc.service.Packing;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}