package cz.app.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuelConsumptionMeterDTO {
    /**
     * consumption per 100 kilometers
     */
    private double averageConsumption;
    /**
     * number of planned kilometers
     */
    private double numberOfKilometers;
    /**
     * fuel price per liter
     */
    private double fuelPrice;


}
