package com.floobyte.franchise.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioWhatsAppService {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Value("${admin.phone.number}")
    private String adminPhoneNumber;

    public void sendMessage(String customerPhoneNumber, String messageBody) {
        sendSms(customerPhoneNumber, messageBody);
        sendSms(adminPhoneNumber, "Admin Alert: " + messageBody);
    }

    private void sendSms(String to, String body) {
        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(twilioPhoneNumber),
                body
        ).create();
    }
}
