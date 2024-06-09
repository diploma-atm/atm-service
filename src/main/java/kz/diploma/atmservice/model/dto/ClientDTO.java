package kz.diploma.atmservice.model.dto;

import kz.diploma.adapter.access.model.ClientClientResponse;
import lombok.Data;

@Data
public class ClientDTO {
    public Integer id;
    public String surname;
    public String name;
    public String lastName;
    public String phoneNumber;
    public Boolean isBlocked;

    public ClientDTO(ClientClientResponse clientResponse) {
        this.id = clientResponse.getId();
        this.surname = clientResponse.getSurname();
        this.name = clientResponse.getName();
        this.lastName = clientResponse.getLastName();
        this.phoneNumber = clientResponse.getPhoneNumber();
        this.isBlocked = clientResponse.getIsBlocked();
    }
}
