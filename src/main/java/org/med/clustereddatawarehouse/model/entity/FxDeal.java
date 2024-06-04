package org.med.clustereddatawarehouse.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FxDeal {

    @Id
    @NotEmpty(message = "Deal id must not be empty")
    @Size(min = 3, message = "Deal id should be in 3 character and above.")
    private String id;

    @Column(nullable = false)
    @NotEmpty(message = "OrderingCurrencyIsoCode must not be empty")
    @Size( min = 3, message = "Ordering currency iso code should be in 3 character and above.")
    private String orderingCurrencyIsoCode;

    @Column(nullable = false)
    @NotEmpty(message = "ToCurrencyIsoCode must not be empty")
    @Size(max = 255, min = 3, message = "To Currency iso code should be in 3 character and above.")
    private String toCurrencyIsoCode;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dealTimestamp;

    @Column(nullable = false)
    @Max(value = (long) Double.MAX_VALUE, message = "to long value")
    @Min(value = 0, message = "deal amount should be a positive value.")
    private Double dealAmount;
}
