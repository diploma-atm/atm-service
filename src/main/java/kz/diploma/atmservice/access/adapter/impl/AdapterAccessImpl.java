package kz.diploma.atmservice.access.adapter.impl;

import kz.diploma.adapter.access.api.AdapterControllerApiClient;
import kz.diploma.atmservice.access.adapter.AdapterAccess;
import kz.diploma.atmservice.model.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdapterAccessImpl implements AdapterAccess {
    private final AdapterControllerApiClient adapterControllerApiClient;

    @Override
    public ClientDTO getClientResponseById(Integer clientId) {
        var response = adapterControllerApiClient.getClient(clientId);
        var client = response.getBody();

        return new ClientDTO(client);
    }

    @Override
    public ClientDTO getClientResponseByPan(String pan) {
        var response = adapterControllerApiClient.getClient1(pan);
        var client = response.getBody();

        return new ClientDTO(client);
    }

    @Override
    public List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName) {
        var response = adapterControllerApiClient.getClientByFio(surname, name, lastName);
        var resps = response.getBody();

        var clients = resps.stream().map(ClientDTO::new).toList();
        return clients;
    }
}
