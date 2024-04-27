package kz.diploma.atmservice.access.adapter;

import kz.diploma.atmservice.model.dto.ClientDTO;

import java.util.List;

public interface AdapterAccess {
    ClientDTO getClientResponseById(Integer clientId);
    ClientDTO getClientResponseByPan(String pan);
    List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName);
}
