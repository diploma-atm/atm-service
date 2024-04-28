package kz.diploma.atmservice.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WithdrawCashRequest extends BaseCashRequest{
    public String pin;
}
