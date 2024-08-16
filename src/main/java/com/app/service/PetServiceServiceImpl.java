package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PetServiceDTO;
import com.app.entities.PetServicesEntity;
import com.app.repository.PetServiceRepo;

@Service
public class PetServiceServiceImpl implements PetServiceService {

    @Autowired
    private PetServiceRepo petServicesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PetServiceDTO createService(PetServiceDTO petServiceDTO) {
        PetServicesEntity petServicesEntity = modelMapper.map(petServiceDTO, PetServicesEntity.class);
        PetServicesEntity savedEntity = petServicesRepository.save(petServicesEntity);
        return modelMapper.map(savedEntity, PetServiceDTO.class);
    }

    @Override
    public PetServiceDTO getServiceById(Integer serviceId) {
        PetServicesEntity petServicesEntity = petServicesRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return modelMapper.map(petServicesEntity, PetServiceDTO.class);
    }

    @Override
    public List<PetServiceDTO> getAllServices() {
        List<PetServicesEntity> services = petServicesRepository.findAll();
        return services.stream()
                .map(service -> modelMapper.map(service, PetServiceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PetServiceDTO updateService(Integer serviceId, PetServiceDTO petServiceDTO) {
        PetServicesEntity existingService = petServicesRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        modelMapper.map(petServiceDTO, existingService);
        PetServicesEntity updatedService = petServicesRepository.save(existingService);
        return modelMapper.map(updatedService, PetServiceDTO.class);
    }

    @Override
    public void deleteService(Integer serviceId) {
        PetServicesEntity petServicesEntity = petServicesRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        petServicesRepository.delete(petServicesEntity);
    }
}
