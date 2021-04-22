package com.tony.demo.payment;

import com.tony.demo.config.feignClients.WorkerFeignClients;
import com.tony.demo.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClients workerFeignClients;

    public Payment getPayment(long workerId, int days) {
        Worker worker = this.workerFeignClients.findById(workerId).get();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
