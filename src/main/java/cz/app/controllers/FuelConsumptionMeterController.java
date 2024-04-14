package cz.app.controllers;

import cz.app.models.dtos.TotalCostDTO;
import cz.app.models.FuelConsumptionMeterService;
import cz.app.models.dtos.TotalKilometersDTO;
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
    public String renderFuelConsumptionMeter(@ModelAttribute TotalCostDTO totalCostDTO, @ModelAttribute TotalKilometersDTO totalKilometersDTO) {
        return "fuel-consumption-meter";
    }

    @PostMapping("/totalcost")
    public String calculateTotalCostOfFuel(@ModelAttribute TotalCostDTO totalCostDTO, Model model, @ModelAttribute TotalKilometersDTO totalKilometersDTO) {
        model.addAttribute("totalCost", fuelConsumptionMeterService.calculateTotalCostOfFuel(totalCostDTO));
        return "fuel-consumption-meter";
    }

    @PostMapping("/totalkilometers")
    public String calculateTotalKilometers(@ModelAttribute TotalKilometersDTO totalKilometersDTO, Model model, @ModelAttribute TotalCostDTO totalCostDTO) {
        model.addAttribute("totalKilometers", fuelConsumptionMeterService.calculateTotalKilometers(totalKilometersDTO));
        return "fuel-consumption-meter";
    }
}
