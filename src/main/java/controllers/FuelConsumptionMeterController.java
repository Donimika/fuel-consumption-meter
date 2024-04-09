package controllers;

import models.FuelConsumptionMeterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fuelcounter")
public class FuelConsumptionMeterController {

    @GetMapping
    public String renderCounter(@ModelAttribute FuelConsumptionMeterDTO fuelConsumptionMeterDTO) {
        return "fuel-consumption-meter";
    }
}
