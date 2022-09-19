package com.epam.javalab32.maintenance_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "repair_id")
    private Long repairId;
    private double repairSum;
    private String description;
    private Date repairDate;
    @Column(nullable = false)
    private int count;
    @Transient
    private Long carId;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @JsonBackReference
    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Repair repair = (Repair) o;
        return repairId != null && Objects.equals(repairId, repair.repairId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
