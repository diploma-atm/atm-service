package kz.diploma.atmservice.controller;

import kz.diploma.atmservice.access.adapter.impl.AdapterAccessImpl;
import kz.diploma.atmservice.model.dto.ClientDTO;
import kz.diploma.atmservice.service.AtmService;
import kz.diploma.integration.yandex.model.FilterDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm-service")
@RequiredArgsConstructor
public class AtmServiceController {
    private final AtmService atmService;

    @GetMapping("/yandex/filter-data")
    public ResponseEntity<FilterDataResponse> getFilterData() {
        return ResponseEntity.ok(atmService.getFilterData());
    }

    @GetMapping("/yandex/speech")
    public ResponseEntity<String> getSpeechData(String text, String speaker) {
        return ResponseEntity.ok(atmService.getBase64(text, speaker));
    }

    @GetMapping("/client/{id}")
    public ClientDTO getClientResponseById(@PathVariable(name = "clientId") Integer clientId) {
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


    @GetMapping("/check/pin")
    public ResponseEntity<Boolean> checkPin(String pin, String pan) {
        return ResponseEntity.ok(atmService.checkPin(pin, pan));
    }


    @PutMapping("/deposit")
    public ResponseEntity<String> depositCash(@RequestBody Long cash,@RequestBody String pan) {
        atmService.depositCash(cash, pan);

        return ResponseEntity.ok("Операция прошла успешно");
    }


    @PutMapping("/withdraw")
    public ResponseEntity<String> withdrawCash(Long cash, String pan) {
        atmService.withdrawCash(cash, pan);

        return ResponseEntity.ok("Операция прошла успешно");
    }
}
