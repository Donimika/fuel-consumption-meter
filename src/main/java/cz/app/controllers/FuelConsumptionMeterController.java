package cz.app.controllers;

import cz.app.models.TotalCostDTO;
import cz.app.models.FuelConsumptionMeterService;
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
    public String renderFuelConsumptionMeter(@ModelAttribute TotalCostDTO totalCostDTO) {
        return "fuel-consumption-meter";
    }

    @PostMapping
    public String calculateTotalCostOfFuel(@ModelAttribute TotalCostDTO totalCostDTO, Model model) {
        model.addAttribute("totalCost", fuelConsumptionMeterService.calculateTotalCostOfFuel(totalCostDTO));
        return "fuel-consumption-meter";
    }
}
