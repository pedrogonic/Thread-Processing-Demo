package com.pedrogonic.threadprocessingdemo.controller;

import com.pedrogonic.threadprocessingdemo.service.WordProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class MainController {

    final WordProcessorService service;

    public MainController(WordProcessorService service) {
        this.service = service;
    }

    @PostMapping("/processInThread")
    public String processInThread(@RequestBody List<String> words) {
        return service.processWordList(words);
    }

    @PostMapping("/processAsync")
    public String processAsync(@RequestBody List<String> words) throws InterruptedException {
        for (String word : words)
            service.processWord(word);
        return "Processing...";
    }

    @PostMapping("/waitProcess")
    public String waitProcess(@RequestBody List<String> words) throws InterruptedException, ExecutionException {

        List<CompletableFuture> completableFutures = new ArrayList<>();

        for (String word : words)
            completableFutures.add(service.processWordAsync(word));

        CompletableFuture.allOf( completableFutures.toArray(new CompletableFuture[completableFutures.size()]) ).join();
        for (CompletableFuture cf : completableFutures)
            log.info((String) cf.get());
        return "Finished parallel processes! \n" + completableFutures.stream().map(cf -> {
                            try {
                                return (String) cf.get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            return "";
                        }).collect(Collectors.joining(", ")) + ".";
    }

}
