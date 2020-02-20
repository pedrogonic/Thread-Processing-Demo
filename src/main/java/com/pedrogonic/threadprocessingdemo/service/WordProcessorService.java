package com.pedrogonic.threadprocessingdemo.service;

import com.pedrogonic.threadprocessingdemo.process.WordListProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordProcessorService {

    public String processWordList(List<String> words) {

        Thread t1 = new Thread(new WordListProcessor(words));

        t1.start();

        return "Processing...";
    }

}
