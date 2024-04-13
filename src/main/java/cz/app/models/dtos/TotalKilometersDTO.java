package cz.app.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalKilometersDTO {
    /**
     * consumption per 100 kilometers
     */
    private String averageConsumption;
    /**
     * total fuel cost planned to refuel or already refueled
     */
    private String totalFuelCost;
    /**
     * fuel price per liter
     */
    private String fuelPrice;
}
