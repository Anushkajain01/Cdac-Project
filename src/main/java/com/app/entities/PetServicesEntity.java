package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.app.entityutils.PetServices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "service")
public class PetServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @NotNull
    private LocalDate creationDate;

    private LocalDate upDatedOn;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PetServices serviceName;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

   
}
