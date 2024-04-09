package models;


import org.springframework.stereotype.Service;

@Service
public class FuelConsumptionMeterService {
    public float calculate(FuelConsumptionMeterDTO fuelConsumptionMeterDTO) {
        float totalFuelNeeded = fuelConsumptionMeterDTO.getNumberOfKilometers() * (fuelConsumptionMeterDTO.getAverageConsumption() / 100);
        float totalCostOfFuel = totalFuelNeeded * fuelConsumptionMeterDTO.getFuelPrice();
        return totalCostOfFuel;
    }
}