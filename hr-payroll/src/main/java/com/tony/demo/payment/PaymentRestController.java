package com.tony.demo.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/payments")
public class PaymentRestController {

    private final PaymentService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{workerId}/days/{days}")
    public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return service.getPayment(workerId, days);
    }
}
