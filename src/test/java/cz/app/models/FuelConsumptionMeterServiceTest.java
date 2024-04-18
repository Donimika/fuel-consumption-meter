package cz.app.models;

import cz.app.models.dtos.TotalCostDTO;
import cz.app.models.dtos.TotalKilometersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class FuelConsumptionMeterServiceTest {

    @Test
    void testResultOfTotalCostCalculation() {
        // Instantiate FuelConsumptionMeterService
        FuelConsumptionMeterService service = new FuelConsumptionMeterService();
        // Create TotalCostDTO with example values
        TotalCostDTO totalCostDTO = new TotalCostDTO();
        totalCostDTO.setAverageConsumption("6"); // Example value
        totalCostDTO.setNumberOfKilometers("500"); // Example value
        totalCostDTO.setFuelPrice("37.2"); // Example value
        // Calculate total cost of fuel
        String costResult = service.calculateTotalCostOrKilometers(totalCostDTO, true);
        // Assert the result
        assertEquals("1116.0", costResult);
    }

    @Test
    void testResultOfTotalKilometersCalculation() {
        // Instantiate FuelConsumptionMeterService
        FuelConsumptionMeterService service = new FuelConsumptionMeterService();
        // Create TotalKilometersDTO with example values
        TotalKilometersDTO totalKilometersDTO = new TotalKilometersDTO();
        totalKilometersDTO.setAverageConsumption("6");
        totalKilometersDTO.setTotalFuelCost("1200");
        totalKilometersDTO.setFuelPrice("38.1");
        // Calculate total kilometers
        String costResult = service.calculateTotalCostOrKilometers(totalKilometersDTO, false);
        // Assert the result
        assertEquals("524.934", costResult);
    }

}