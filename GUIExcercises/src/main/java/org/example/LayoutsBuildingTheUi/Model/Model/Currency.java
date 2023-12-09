package org.example.LayoutsBuildingTheUi.Model.Model;

public class Currency {
    private String name;
    private double conversionRate;

    public Currency(String name, double conversionRate) {
        this.name = name;
        this.conversionRate = conversionRate;
    }

    public String getName() {
        return name;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
