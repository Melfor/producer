package ru.rtmis.melfor.calcproducer.service.generator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimpleRandomTopicService implements RandomTopicService {
    private static final Random RANDOM = new Random();

    @Override
    public String generate() {
        Operation[] values = Operation.values();
        int randomPick = RANDOM.nextInt(values.length);
        return values[randomPick].name().toLowerCase();
    }
}
