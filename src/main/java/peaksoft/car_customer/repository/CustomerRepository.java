package peaksoft.car_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.car_customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}