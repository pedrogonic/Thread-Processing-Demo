package com.pedrogonic.threadprocessingdemo.service;

import com.pedrogonic.threadprocessingdemo.process.WordListProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class WordProcessorService {

    public String processWordList(List<String> words) {

        Thread t1 = new Thread(new WordListProcessor(words));

        t1.start();

        return "Processing...";
    }

    @Async
    public void processWord(String word) throws InterruptedException {
        Long duration = new Random().nextInt(10) * 1000L;
        Thread.sleep(duration);
        log.info(duration/1000 + " seconds: " + word);
    }

    @Async
    public CompletableFuture<String> processWordAsync(String word) throws InterruptedException {
        Long duration = new Random().nextInt(10) * 1000L;
        Thread.sleep(duration);
        String msg = duration/1000 + " seconds: " + word;
        log.info(msg);

        msg = "Processed word " + word + " in " + duration/1000 + " seconds";
        return CompletableFuture.completedFuture(msg);
    }

}
