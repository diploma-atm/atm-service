package kz.diploma.atmservice.model.request;

import lombok.Data;

@Data
public abstract class BaseCashRequest {
    public Long cash;
    public String pan;
}
