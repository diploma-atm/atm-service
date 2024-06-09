package kz.diploma.atmservice.controller;

import kz.diploma.atmservice.model.dto.ClientDTO;
import kz.diploma.atmservice.model.request.DepositCashRequest;
import kz.diploma.atmservice.model.request.WithdrawCashRequest;
import kz.diploma.atmservice.model.request.YandexRequest;
import kz.diploma.atmservice.model.response.CashResponse;
import kz.diploma.atmservice.model.response.YandexResponse;
import kz.diploma.atmservice.service.AtmService;
import kz.diploma.integration.yandex.model.FilterDataResponse;

import kz.diploma.shared.library.security.annotation.PublicAccess;
import kz.diploma.shared.library.security.annotation.RolesAllowed;
import kz.diploma.shared.library.security.model.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm-service")
@RequiredArgsConstructor
@RolesAllowed(value = Roles.CLIENT)
public class AtmServiceController {
    private final AtmService atmService;

    @PublicAccess
    @GetMapping("/yandex/filter-data")
    public ResponseEntity<FilterDataResponse> getFilterData() {
        return ResponseEntity.ok(atmService.getFilterData());
    }

    @PublicAccess
    @PostMapping("/yandex/speech")
    public ResponseEntity<YandexResponse> getSpeechData(@RequestBody YandexRequest request) {
        return ResponseEntity.ok(new YandexResponse(atmService.getBase64(request)));
    }

    @GetMapping("/client/{id}")
    public ClientDTO getClientResponseById(@PathVariable(name = "id") Integer clientId) {
        return atmService.getClientResponseById(clientId);
    }

    @GetMapping("/client/pan")
    public ClientDTO getClientResponseByPan(String pan) {
        return atmService.getClientResponseByPan(pan);
    }

    @GetMapping("/client/fio")
    public List<ClientDTO> getClientResponseByFio(String surname, String name, String lastName) {
        return atmService.getClientResponseByFio(surname, name, lastName);
    }

    @PutMapping("/deposit")
    public ResponseEntity<CashResponse> depositCash(@RequestBody DepositCashRequest request) {
        atmService.depositCash(request);

        return ResponseEntity.ok(new CashResponse("Операция прошла успешно"));
    }


    @PutMapping("/withdraw")
    public ResponseEntity<CashResponse> withdrawCash(@RequestBody WithdrawCashRequest request) {
        atmService.withdrawCash(request);

        return ResponseEntity.ok(new CashResponse("Операция прошла успешно"));
    }
}
