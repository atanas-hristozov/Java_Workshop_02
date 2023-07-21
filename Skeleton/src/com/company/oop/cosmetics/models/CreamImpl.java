package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends ProductImpl implements Cream {
    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 15;
    public static final String CREAM_NAME_SHOULD_BE_BETWEEN_3_AND_15_CHARACTERS = "Cream name should be between 3 and 15 characters";
    public static final String BRAND_NAME_SHOULD_BE_BETWEEN_3_AND_15_CHARACTERS = "Brand name should be between 3 and 15 characters";
    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent =scent;
    }

    @Override
    public ScentType getScent() {
        return scent;
    }


    @Override
    protected void setName(String name) {
        ValidationHelpers.validateStringLength(name, MIN_LENGTH, MAX_LENGTH, CREAM_NAME_SHOULD_BE_BETWEEN_3_AND_15_CHARACTERS);
        super.setName(name);
    }

    @Override
    protected void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand,MIN_LENGTH,MAX_LENGTH, BRAND_NAME_SHOULD_BE_BETWEEN_3_AND_15_CHARACTERS);
        super.setBrand(brand);
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.print());
        builder.append(String.format("\n #Scent: %s", getScent()));
        return builder.toString();
    }
}
