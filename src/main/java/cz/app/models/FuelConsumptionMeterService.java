package cz.app.models;


import cz.app.exceptions.NegativeValueException;
import cz.app.exceptions.InvalidNumberInputException;
import org.springframework.stereotype.Service;

@Service
public class FuelConsumptionMeterService {
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
    public String calculateTotalCostOfFuel(TotalCostDTO totalCostDTO) {
        try {
            parseTotalCostDTO(totalCostDTO);
            validateNegativeInput();
        } catch (NegativeValueException | InvalidNumberInputException e) {
            return e.getMessage();
        }
        double totalFuelNeeded = numberOfKilometers * (averageConsumption / 100);
        double totalCostOfFuel = Math.round((totalFuelNeeded * fuelPrice) * 100.0) / 100.0;
        return Double.toString(totalCostOfFuel);
    }

    private void parseTotalCostDTO(TotalCostDTO totalCostDTO) throws InvalidNumberInputException {
            try  {
                averageConsumption = Double.parseDouble(totalCostDTO.getAverageConsumption());
                numberOfKilometers = Double.parseDouble(totalCostDTO.getNumberOfKilometers());
                fuelPrice = Double.parseDouble(totalCostDTO.getFuelPrice());
            } catch (NumberFormatException e) {
                throw new InvalidNumberInputException("Error: Input values have to be filled and they have to be numbers.");
            }

    }

    private void validateNegativeInput() throws NegativeValueException {
        if (numberOfKilometers < 0 || averageConsumption < 0 || fuelPrice < 0) {
            throw new NegativeValueException("Error: Input values cannot be negative.");
        }
    }
}
