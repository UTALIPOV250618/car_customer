package peaksoft.car_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.car_customer.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}