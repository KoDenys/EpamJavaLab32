package com.epam.javalab32.maintenance_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NamedQueries(
        @NamedQuery(
                name = "Car.findAllCarsForUser",
                query ="select c from Car c where c.user.userId = ?1"
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "Car.findAllCarsWithRepair",
                query = "SELECT distinct car.* FROM car, repair WHERE car.car_id = repair.car_id",
                resultSetMapping = "carEntityMapping"
        )
)
@Entity
@SqlResultSetMapping(
        name = "carEntityMapping",
        classes = {
                @ConstructorResult(
                        targetClass = Car.class,
                        columns = {
                                @ColumnResult(name = "car_id", type = Long.class),
                                @ColumnResult(name = "registration_number", type = String.class),
                                @ColumnResult(name = "car_name", type = String.class),
                                @ColumnResult(name = "model", type = String.class),
                                @ColumnResult(name = "color", type = String.class),
                                @ColumnResult(name = "year_manufacture", type = Integer.class),
                                @ColumnResult(name = "mileage", type = Integer.class),
                                @ColumnResult(name = "blocked", type = Boolean.class),
                                @ColumnResult(name = "user_id", type = Long.class),
                        }
                )
        }
)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long carId;
    @Column(nullable = false, unique = true)
    private String registrationNumber;
    @Column(nullable = false)
    private String carName;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private int yearManufacture;
    private int mileage;
    private boolean blocked;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "car_id", referencedColumnName = "car_Id")
    @Column(nullable = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Repair> repairs;
    @Transient
    private Long userId;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return carId != null && Objects.equals(carId, car.carId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Car(Long carId, String registrationNumber, String carName, String model, String color, int yearManufacture, int mileage, boolean blocked, Long userId) {
        this.carId = carId;
        this.registrationNumber = registrationNumber;
        this.carName = carName;
        this.model = model;
        this.color = color;
        this.yearManufacture = yearManufacture;
        this.mileage = mileage;
        this.blocked = blocked;
        this.userId = userId;
        this.repairs = null;
        this.user = null;
    }
}
