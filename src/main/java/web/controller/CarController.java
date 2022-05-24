package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("BMW", 5, 300));
        carList.add(new Car("BMW", 6, 250));
        carList.add(new Car("Mercedes", 2, 250));
        carList.add(new Car("Chevrolet", 4, 330));
        carList.add(new Car("Chevrolet", 5, 350));
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count,
                            Model model) {
        List<Car> resultCarList;

        if (count == null || count > carList.size()) {
            resultCarList = new ArrayList<>(carList);
        } else {
            resultCarList = carList.subList(0,count);
        }

        model.addAttribute("cars", resultCarList);

        return "cars";
    }
}
