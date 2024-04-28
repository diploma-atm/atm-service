package kz.diploma.atmservice.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public abstract class BaseCashRequest {
    @PositiveOrZero
    public Long cash;
    @NotNull
    public String pan;
}
