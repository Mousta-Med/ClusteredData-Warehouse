package org.med.clustereddatawarehouse.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FxDealReqDto {

    @NotEmpty(message = "Deal id must not be empty")
    @Size(min = 3, message = "Deal id should be in 3 character and above.")
    private String id;

    @NotEmpty(message = "OrderingCurrencyIsoCode must not be empty")
    @Size(min = 3, message = "Ordering currency iso code should be in 3 character and above.")
    private String orderingCurrencyIsoCode;

    @NotEmpty(message = "ToCurrencyIsoCode must not be empty")
    @Size(min = 3, message = "To Currency iso code should be in 3 character and above.")
    private String toCurrencyIsoCode;

    @Max(value = (long) Double.MAX_VALUE, message = "to long value")
    @Min(value = 0, message = "deal amount should be a positive value.")
    private Double dealAmount;
}
