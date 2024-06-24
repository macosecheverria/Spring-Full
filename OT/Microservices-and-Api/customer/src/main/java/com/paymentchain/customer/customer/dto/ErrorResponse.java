package com.paymentchain.customer.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    public String message;

    public Integer statusCode;
}
