package cz.app.controllers;

import cz.app.models.dtos.TotalCostDTO;
import cz.app.models.FuelConsumptionMeterService;
import cz.app.models.dtos.TotalKilometersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/counter")
public class FuelConsumptionMeterController {
    @Autowired
    FuelConsumptionMeterService fuelConsumptionMeterService;

    @GetMapping
    public String renderFuelConsumptionMeter(@ModelAttribute TotalCostDTO totalCostDTO, @ModelAttribute TotalKilometersDTO totalKilometersDTO,
                                             @RequestParam(value = "lang", defaultValue = "en") String lang,
                                             Model model) {
        model.addAttribute("lang", lang);
        return "fuel-consumption-meter";
    }

    @PostMapping("/totalcost")
    public String calculateTotalCostOfFuel(@ModelAttribute TotalCostDTO totalCostDTO, Model model, TotalKilometersDTO totalKilometersDTO,
                                           @RequestParam(value = "lang", defaultValue = "en") String lang) {
        model.addAttribute("totalCost", fuelConsumptionMeterService.calculateTotalCostOrKilometers(totalCostDTO, true));
        model.addAttribute("lang", lang);
        return "fuel-consumption-meter";
    }

    @PostMapping("/totalkilometers")
    public String calculateTotalKilometers(@ModelAttribute TotalKilometersDTO totalKilometersDTO, Model model, TotalCostDTO totalCostDTO,
                                           @RequestParam(value = "lang", defaultValue = "en") String lang) {
        model.addAttribute("totalKilometers", fuelConsumptionMeterService.calculateTotalCostOrKilometers(totalKilometersDTO, false));
        model.addAttribute("lang", lang);
        return "fuel-consumption-meter";
    }
}
