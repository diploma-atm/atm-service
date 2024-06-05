package kz.diploma.atmservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.diploma.atmservice.access.adapter.AdapterAccess;
import kz.diploma.atmservice.access.yandex.YandexAccess;
import kz.diploma.atmservice.model.dto.ClientDTO;
import kz.diploma.atmservice.model.request.DepositCashRequest;
import kz.diploma.atmservice.model.request.WithdrawCashRequest;
import kz.diploma.atmservice.model.request.YandexRequest;
import kz.diploma.atmservice.service.AtmService;
import kz.diploma.integration.yandex.model.FilterDataResponse;
import kz.diploma.library.shared.error_handling.exception.NegativeBalanceException;
import kz.diploma.library.shared.model.entity.ProductEntity;
import kz.diploma.library.shared.model.repository.AccountRepository;
import kz.diploma.library.shared.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtmServiceImpl implements AtmService {
    private final YandexAccess yandexAccess;
    private final AdapterAccess adapterAccess;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    @Override
    public ClientDTO getClientResponseById(Integer clientId) {
        return adapterAccess.getClientResponseById(clientId);
    }

    @Override
    public ClientDTO getClientResponseByPan(String pan) {
        return adapterAccess.getClientResponseByPan(pan);
    }

    @Override
    public List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName) {
        return adapterAccess.getClientResponseByFio(surname, name, lastName);
    }

    @Override
    public void depositCash(DepositCashRequest request) {
        var product = getProductEntity(request.getPan());

        var account = product.account;
        account.cash += request.cash;

        if(account.cash < 0){
            throw new NegativeBalanceException("Negative balance on account");
        }

        accountRepository.save(account);
        productRepository.save(product);
    }

    @Override
    public void withdrawCash(WithdrawCashRequest request) {
        var product = getProductEntity(request.pan);

        var account = product.account;
        account.cash -= request.cash;

        if(account.cash < 0){
            throw new NegativeBalanceException("Negative balance on account");
        }

        accountRepository.save(account);
        productRepository.save(product);
    }

    @Override
    public String getBase64(YandexRequest request) {
        return yandexAccess.getBase64(request.text, request.speaker.toUpperCase());
    }

    @Override
    public FilterDataResponse getFilterData(){
        return yandexAccess.getFilterData();
    }

    private ProductEntity getProductEntity(String pan) {
        var product = productRepository.findByPan(pan);

        if (product.isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }

        return product.get();
    }
}
