package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends ProductImpl implements Shampoo {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    public static final String ILLEGAL_MILLILITERS = "Milliliters should not be negative";
    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType genderType, int milliliters, UsageType usageType) {
        super(name, brand, price, genderType);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    @Override
    public int getMillilitres() {
        return milliliters;
    }
    public void setMilliliters(int milliliters){
        if(milliliters<0){
            throw new IllegalArgumentException(ILLEGAL_MILLILITERS);
        } else {
            this.milliliters = milliliters;
        }
    }
    @Override
    public UsageType getUsageType() {
        return usageType;
    }

    @Override
    public String print() {
        return String.format("%s%n #Milliliters: %d%n #Usage: %s",super.print(),getMillilitres(),getUsageType());
    }

    /* This method should be uncommented when you are done with the class.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
