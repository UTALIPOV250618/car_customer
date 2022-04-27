package peaksoft.car_customer.model;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    private String brand;
    private String model;
    @ManyToOne()
    private Customer customer;

}
