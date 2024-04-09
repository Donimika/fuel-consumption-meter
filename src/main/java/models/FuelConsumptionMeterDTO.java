package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuelConsumptionMeterDTO {
    /**
     * consumption per 100 kilometers
     */
    private float averageConsumption;
    /**
     * number of planned kilometers
     */
    private float numberOfKilometers;
    /**
     * fuel price per liter
     */
    private float fuelPrice;


}
