package controllers;

import models.FuelConsumptionMeterDTO;
import models.FuelConsumptionMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/counter")
public class FuelConsumptionMeterController {
    @Autowired
    FuelConsumptionMeterService fuelConsumptionMeterService;

    @GetMapping
    public String renderFuelConsumptionMeter(@ModelAttribute FuelConsumptionMeterDTO fuelConsumptionMeterDTO) {
        return "fuel-consumption-meter";
    }

    @PostMapping
    public String calculateTotalCostOfFuel(@ModelAttribute FuelConsumptionMeterDTO fuelConsumptionMeterDTO, Model model) {
        model.addAttribute("totalCostOfFuel", fuelConsumptionMeterService.calculateTotalCostOfFuel(fuelConsumptionMeterDTO));
        return "fuel-consumption-meter";
    }
}
