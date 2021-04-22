package com.tony.hrworker.worker;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workers")
public class WorkerRestController {

    private final WorkerRepository workerRepository;
    private final Environment environment;
    private final static Logger logger = LoggerFactory.getLogger(WorkerRestController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Worker> findById(@PathVariable Long id) {
        this.logger.info("PORT = " + this.environment.getProperty("local.server.port"));
        return workerRepository.findById(id);
    }
}
