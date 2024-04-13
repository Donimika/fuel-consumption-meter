package cz.app.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalCostDTO {
    /**
     * consumption per 100 kilometers
     */
    private String averageConsumption;
    /**
     * number of planned kilometers
     */
    private String numberOfKilometers;
    /**
     * fuel price per liter
     */
    private String fuelPrice;

}
