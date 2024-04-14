package cz.app.models;


import cz.app.exceptions.InvalidInputException;
import cz.app.exceptions.InvalidNumberInputException;
import cz.app.models.dtos.TotalCostDTO;
import cz.app.models.dtos.TotalKilometersDTO;
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

    /**
     * total fuel cost from input
     */
    private double totalFuelCost;
    /**
     * Merge calculateTotalCostOfFuel and calculateTotalKilometers into one method.
     * This method will have two parameters: Object dto and a boolean calculateCost (false for calculating kilometers).
     * It cooperates with the parsing method, using instanceof to handle different DTO types.
     */
    public String calculateTotalCostOfFuel(TotalCostDTO totalCostDTO) {
        try {
            parseDTO(totalCostDTO);
            validateNegativeInput();
        } catch (InvalidInputException | InvalidNumberInputException e) {
            return e.getMessage();
        }
        double totalFuelNeeded = numberOfKilometers * (averageConsumption / 100);
        double totalCostOfFuel = Math.round((totalFuelNeeded * fuelPrice) * 100.0) / 100.0;
        return Double.toString(totalCostOfFuel);
    }

    public String calculateTotalKilometers(TotalKilometersDTO totalKilometersDTO) {
        try {
            parseDTO(totalKilometersDTO);
            validateNegativeInput();
        } catch (InvalidInputException | InvalidNumberInputException e) {
            return e.getMessage();
        }
        double kilometers = totalFuelCost / (fuelPrice * (averageConsumption / 100.0));
        double roundedKilometers = Math.round(kilometers * 1000.0) / 1000.0;
        return Double.toString(roundedKilometers);
    }
    /**
     * Parses the attributes of a DTO object and assigns them to the corresponding fields.
     *
     * @param dto The DTO object to parse.
     * @throws InvalidNumberInputException If input values are not filled or not numbers.
     */
    public void parseDTO(Object dto) throws InvalidNumberInputException {
        try {
            if (dto instanceof TotalKilometersDTO) {
                TotalKilometersDTO totalKilometersDTO = (TotalKilometersDTO) dto;
                averageConsumption = Double.parseDouble(totalKilometersDTO.getAverageConsumption());
                totalFuelCost = Double.parseDouble(totalKilometersDTO.getTotalFuelCost());
                fuelPrice = Double.parseDouble(totalKilometersDTO.getFuelPrice());
            } else if (dto instanceof TotalCostDTO) {
                TotalCostDTO totalCostDTO = (TotalCostDTO) dto;
                averageConsumption = Double.parseDouble(totalCostDTO.getAverageConsumption());
                numberOfKilometers = Double.parseDouble(totalCostDTO.getNumberOfKilometers());
                fuelPrice = Double.parseDouble(totalCostDTO.getFuelPrice());
            } else {
                throw new IllegalArgumentException("Invalid DTO type");
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberInputException("Error: Input values have to be filled and they have to be numbers.");
        }
    }

    private void validateNegativeInput() throws InvalidInputException {
        if (totalFuelCost < 0 || numberOfKilometers < 0 || averageConsumption < 0 || fuelPrice < 0) {
            throw new InvalidInputException("Error: Input values cannot be negative.");
        }
        if (averageConsumption > 500) {
            throw new InvalidInputException("Error: Average consumption can't be that high. " +
                    "The most fuel-hungry vehicle, Bentley Meteoer, reqires 117 litres of fuel to go 100km." +
                    "It's highly unlikely you'd need more than 500.");
        }
    }
}
