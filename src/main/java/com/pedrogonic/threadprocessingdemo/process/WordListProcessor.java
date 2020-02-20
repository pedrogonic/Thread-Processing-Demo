package com.pedrogonic.threadprocessingdemo.process;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class WordListProcessor implements Runnable {

    List<String> words;

    public WordListProcessor(List<String> words) {
        this.words = words;
    }

    @Override
    public void run() {

        for(String word : words) {
            try {
                log.info(word);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
