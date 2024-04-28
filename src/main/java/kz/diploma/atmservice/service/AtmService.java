package kz.diploma.atmservice.service;

import kz.diploma.atmservice.model.dto.ClientDTO;
import kz.diploma.atmservice.model.request.DepositCashRequest;
import kz.diploma.atmservice.model.request.WithdrawCashRequest;
import kz.diploma.integration.yandex.model.FilterDataResponse;

import java.util.List;

public interface AtmService {
    ClientDTO getClientResponseById(Integer clientId);
    ClientDTO getClientResponseByPan(String pan);
    List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName);

    boolean checkPin(String pin, String pan);

    void depositCash(DepositCashRequest request);

    void withdrawCash(WithdrawCashRequest request);

    String getBase64(String text, String speaker);

    FilterDataResponse getFilterData();
}
