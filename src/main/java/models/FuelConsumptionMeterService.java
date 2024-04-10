package models;


import exceptions.NegativeValueException;
import org.springframework.stereotype.Service;

@Service
public class FuelConsumptionMeterService {
    public String calculateTotalCostOfFuel(FuelConsumptionMeterDTO fuelConsumptionMeterDTO) {
        try {
            validateInput(fuelConsumptionMeterDTO);
        } catch (NegativeValueException e) {
            return e.getMessage();
        }
        double totalFuelNeeded = fuelConsumptionMeterDTO.getNumberOfKilometers() * (fuelConsumptionMeterDTO.getAverageConsumption() / 100);
        double totalCostOfFuel = Math.round((totalFuelNeeded * fuelConsumptionMeterDTO.getFuelPrice()) * 100.0) / 100.0;
        return Double.toString(totalCostOfFuel);
    }

    private void validateInput(FuelConsumptionMeterDTO fuelConsumptionMeterDTO) {
        if (fuelConsumptionMeterDTO.getNumberOfKilometers() < 0 ||
                fuelConsumptionMeterDTO.getAverageConsumption() < 0 ||
                fuelConsumptionMeterDTO.getFuelPrice() < 0) {
            throw new NegativeValueException("Input values cannot be negative.");
        }
    }
}
