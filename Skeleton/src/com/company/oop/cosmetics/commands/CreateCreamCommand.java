package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCreamCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        return createCream(parameters);

    }

    public String createCream(List<String> parameters){
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = GenderType.valueOf(parameters.get(3).toUpperCase());
        ScentType scent = ScentType.valueOf(parameters.get(4).toUpperCase());

        cosmeticsRepository.createCream(name,brand,price,genderType,scent);
        return String.format(ParsingHelpers.PRODUCT_CREATED,"Cream",name);
    }

}
