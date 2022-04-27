package peaksoft.car_customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.car_customer.model.Car;
import peaksoft.car_customer.model.Customer;
import peaksoft.car_customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    public void save(Customer customer){
        repository.save(customer);
    }

    public Customer getById(long id){
        return repository.findById(id).get();
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public List<Car> getListOfCars(Customer customer){
        List<Car> cars = new ArrayList<>();
        customer.setCars(cars);
        return customer.getCars();
    }
}
