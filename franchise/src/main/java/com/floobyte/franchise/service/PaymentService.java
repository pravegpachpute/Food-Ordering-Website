package com.floobyte.franchise.service;

import com.floobyte.franchise.model.Order;
import com.floobyte.franchise.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
