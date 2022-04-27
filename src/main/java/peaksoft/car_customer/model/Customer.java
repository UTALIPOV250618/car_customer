package peaksoft.car_customer.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;
    private String cName;
    private String cLastname;
    @OneToMany(mappedBy = "customer")
    private List<Car> cars = new java.util.ArrayList<>();
}