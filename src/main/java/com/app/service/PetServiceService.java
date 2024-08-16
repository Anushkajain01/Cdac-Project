package com.app.service;

import com.app.dto.PetServiceDTO;
import java.util.List;

public interface PetServiceService {
    PetServiceDTO createService(PetServiceDTO petServiceDTO);
    PetServiceDTO getServiceById(Integer serviceId);
    List<PetServiceDTO> getAllServices();
    PetServiceDTO updateService(Integer serviceId, PetServiceDTO petServiceDTO);
    void deleteService(Integer serviceId);
}
