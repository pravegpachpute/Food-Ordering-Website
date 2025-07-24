package com.floobyte.franchise.controller;

import com.floobyte.franchise.service.impl.TwilioWhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/whatsapp")
public class WhatsAppController {
    @Autowired
    private TwilioWhatsAppService twilioWhatsAppService;




    @PostMapping("/send")
    public String sendMessage(@RequestParam String customerPhoneNumber, @RequestParam String messageBody) {
        twilioWhatsAppService.sendMessage(customerPhoneNumber, messageBody);
        return "Messages sent successfully!";
    }

//    @PostMapping("/send-bill")
//    public String sendBill(@RequestParam String customerPhoneNumber, @RequestParam String billDetails) {
//        String message = "Your bill details: " + billDetails;
//        twilioWhatsAppService.sendWhatsAppMessage(customerPhoneNumber, message);
//        return "Bill sent successfully!";
//    }

//    @PostMapping("/send-birthday-wish")
//    public String sendBirthdayWish(@RequestParam String customerPhoneNumber) {
//        // Remove spaces and ensure the correct format
//        customerPhoneNumber = customerPhoneNumber.replace("", ""); // Remove spaces
//        if (!customerPhoneNumber.startsWith("whatsapp:+")) {
//            customerPhoneNumber = "whatsapp:+91" + customerPhoneNumber.replace("whatsapp:", ""); // Add country code if missing
//        }
//
//        System.out.println("Formatted phone number: " + customerPhoneNumber); // Log the formatted phone number
//        String message = "Happy Birthday! 🎉🎂 Enjoy your special day with a discount on your next order!";
//        twilioWhatsAppService.sendWhatsAppMessage(customerPhoneNumber, message);
//        return "Birthday wish sent successfully!";
//    }
}
