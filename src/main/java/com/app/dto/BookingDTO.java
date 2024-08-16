package com.app.dto;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.app.entityutils.BookingStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookingDTO {
	
	
	private Integer bookingId;
    @NotNull(message = "Booking status cannot be null")
    
    private BookingStatus bookingStatus;

    @NotNull(message = "Start Date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "End Date cannot be null")
    private LocalDate endDate;

    @NotNull(message = "Pet ID cannot be null")
    private Integer petId;
    
    @NotNull
    private Integer petServiceId;
    
//
//    private List<PetServicesEntity> services;
    // Getters and Setters
}
