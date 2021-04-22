package com.tony.demo.config.feignClients;

import com.tony.demo.worker.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClients {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Worker> findById(@PathVariable Long id);
}
