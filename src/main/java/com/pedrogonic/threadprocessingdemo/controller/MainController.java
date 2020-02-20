package com.pedrogonic.threadprocessingdemo.controller;

import com.pedrogonic.threadprocessingdemo.service.WordProcessorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    final WordProcessorService service;

    public MainController(WordProcessorService service) {
        this.service = service;
    }

    @PostMapping("/processInThread")
    public String processInThread(@RequestBody List<String> words) {
        return service.processWordList(words);
    }

}
