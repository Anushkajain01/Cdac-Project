package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookingDTO;
import com.app.entities.Booking;
import com.app.entities.Pet;
import com.app.entities.PetServicesEntity;
import com.app.repository.BookingRepo;
import com.app.repository.PetRepo;
import com.app.repository.PetServiceRepo;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepository;

    @Autowired
    private PetRepo petRepository;

    @Autowired
    private PetServiceRepo petServicesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        booking.setBookingDate(LocalDate.now());

        Pet pet = petRepository.findById(bookingDTO.getPetId())
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));
        booking.setPet(pet);

        Booking savedBooking = bookingRepository.save(booking);
        return modelMapper.map(savedBooking, BookingDTO.class);
    }

    @Override
    public BookingDTO getBookingById(Integer bookingId) {
        return bookingRepository.findById(bookingId)
                .map(b -> modelMapper.map(b, BookingDTO.class))
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(booking -> modelMapper.map(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO updateBooking(Integer bookingId, BookingDTO bookingDTO) {
        return bookingRepository.findById(bookingId)
                .map(existingBooking -> {
                    modelMapper.map(bookingDTO, existingBooking);
                    Booking updatedBooking = bookingRepository.save(existingBooking);
                    return modelMapper.map(updatedBooking, BookingDTO.class);
                }).orElseThrow(() -> new EntityNotFoundException("Booking not found"));
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new EntityNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(bookingId);
    }
}