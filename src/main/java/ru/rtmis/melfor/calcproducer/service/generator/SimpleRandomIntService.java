package ru.rtmis.melfor.calcproducer.service.generator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimpleRandomIntService implements RandomIntService{
    private static final Random RANDOM = new Random();
    private static final int MIN = 1;
    private static final int MAX = 1000;

    @Override
    public int generate() {
        return MIN + RANDOM.nextInt(MAX - MIN);
    }
}
