package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

abstract class ProductImpl implements Product {
    public static final String NAME_INVALID_MESSAGE = "Name should be between 2 and 10 symbols.";
    public static final int NAME_MAX_LENGTH = 10;
    public static final int NAME_MIN_LENGTH = 3;
    public static final String BRAND_INVALID_MESSAGE = "Brand should be between 2 and 10 symbols.";
    public static final int BRAND_MAX_LENGHT = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final String INVALID_PRICE = "Price should non be negative";
    private String name;
    private String brand;
    private double price;
    private GenderType gender;
    public ProductImpl(String name, String brand, double price, GenderType gender){
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }
    protected void setName(String name){
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, NAME_INVALID_MESSAGE);
        this.name=name;
    }

    @Override
    public String getBrandName() {
        return brand;
    }
    protected void setBrand(String brand){
        ValidationHelpers.validateStringLength(brand, BRAND_MIN_LENGTH, BRAND_MAX_LENGHT, BRAND_INVALID_MESSAGE);
        this.brand=brand;
    }

    @Override
    public double getPrice() {
        return price;
    }
    protected void setPrice(double price){
        if(price<0){
            throw new IllegalArgumentException(INVALID_PRICE);
        } else {
            this.price=price;
        }
    }
    @Override
    public GenderType getGenderType() {
        return gender;
    }

    @Override
    public String print() {
        return String.format("#%s %s%n #Price: $%.2f%n #Gender: %s",getName(),getBrandName(),getPrice(),getGenderType());
    }
}
