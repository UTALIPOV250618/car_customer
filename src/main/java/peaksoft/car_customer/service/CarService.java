package peaksoft.car_customer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.car_customer.model.Car;
import peaksoft.car_customer.repository.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars (){
        return carRepository.findAll();
    }

    public Car getById(long id){
        return carRepository.findById(id).get();
    }

    public void save(Car car){
        carRepository.save(car);
    }
    public void deleteById(long id){
        carRepository.deleteById(id);
    }



}
