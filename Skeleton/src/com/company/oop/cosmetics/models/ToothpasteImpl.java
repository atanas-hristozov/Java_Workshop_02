package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    private List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name,brandName,price,genderType);
        this.ingredients = ingredients;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }
    @Override
    public String print() {
        StringBuilder ing = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        builder.append(super.print());
        for (int i = 0; i < ingredients.size(); i++) {

            if (i == ingredients.size() - 1) {
                ing.append(ingredients.get(i));
            } else {
                ing.append(ingredients.get(i) + ", ");
            }
        }
        builder.append(String.format("\n #Ingredients: [%s]", ing));
        return builder.toString();
    }

    /* This method should be uncommented when you are done with the class.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}
