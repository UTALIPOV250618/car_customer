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
import peaksoft.car_customer.model.Customer;
import peaksoft.car_customer.service.CustomerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;


    @RequestMapping("/")
    public String viewCustomerPage(Model model){
        List<Customer> customerList = service.getAllCustomer();
        model.addAttribute("customerList",customerList);
        return "customer/customer_page";
    }
//    @RequestMapping("/listOfCars")
//    public String viewCustomerCarList(Model model,Customer customer){
//        List<Car> customerListOfCar = service.getListOfCars(customer);
//        model.addAttribute("customerListOfCars",customerListOfCar);
//        return "customer/list_of_cars";
//    }
    @RequestMapping("/new")
    public String showNewPage(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer/new_customer";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer")Customer customer){
        service.save(customer);
        return "redirect:/customer/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id")long id){
        ModelAndView view = new ModelAndView("customer/edit_customer");
        Customer customer = service.getById(id);
        view.addObject("customer",customer);
        return view;
    }
    @RequestMapping("/delete/{id}")
    public  String deleteCustomer(@PathVariable(name = "id")long id){
        service.deleteById(id);
        return "redirect:/customer/";
    }

}
