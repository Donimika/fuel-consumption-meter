package cz.app.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalKilometersDTO {
    /**
     * consumption per 100 kilometers
     */
    private String averageConsumptionTotKm;
    /**
     * total fuel cost planned to refuel or already refueled
     */
    private String priceForRefueling;
    /**
     * fuel price per liter
     */
    private String fuelPriceTotKm;
}
