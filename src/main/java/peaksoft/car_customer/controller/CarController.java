package peaksoft.car_customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.car_customer.model.Car;
import peaksoft.car_customer.service.CarService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @RequestMapping("/")
    public String viewCarsPage(Model model){
        List<Car> carList = carService.getAllCars();
        model.addAttribute("carList",carList);
        return "car/car_page";
    }
    @RequestMapping("/new")
    public String addNewCar(Model model){
        Car car = new Car();
        model.addAttribute("car",car);
        return "car/new_car";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car")Car car){
        carService.save(car);
        return "redirect:/cars/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView carEdit(@PathVariable(name = "id")long id){
        ModelAndView view = new ModelAndView("car/edit_car");
        Car car = carService.getById(id);
        view.addObject("car",car);
        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id")long id){
        carService.deleteById(id);
        return "redirect:/cars/";
    }

}
