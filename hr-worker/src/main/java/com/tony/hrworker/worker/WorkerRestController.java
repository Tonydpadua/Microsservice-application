package com.tony.hrworker.worker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workers")
public class WorkerRestController {

    private final WorkerRepository workerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Worker> findById(@PathVariable Long id) {
        return workerRepository.findById(id);
    }
}
