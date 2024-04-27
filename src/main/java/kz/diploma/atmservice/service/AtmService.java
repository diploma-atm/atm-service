package kz.diploma.atmservice.service;

import kz.diploma.atmservice.model.dto.ClientDTO;
import kz.diploma.integration.yandex.model.FilterDataResponse;

import java.util.List;

public interface AtmService {
    ClientDTO getClientResponseById(Integer clientId);
    ClientDTO getClientResponseByPan(String pan);
    List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName);

    boolean checkPin(String pin, String pan);

    void depositCash(Long cash, String pan);

    void withdrawCash(Long cash, String pan);

    String getBase64(String text, String speaker);

    FilterDataResponse getFilterData();
}
