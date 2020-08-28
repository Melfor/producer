package ru.rtmis.melfor.calcproducer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.rtmis.melfor.calcproducer.dto.CalcDto;
import ru.rtmis.melfor.calcproducer.service.generator.CalcDtoGenerationService;
import ru.rtmis.melfor.calcproducer.service.generator.RandomTopicService;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleCalcProducerService implements CalcProducerService {
    private final KafkaTemplate<Long, CalcDto> kafkaCalcTemplate;
    private final ObjectMapper objectMapper;
    private final CalcDtoGenerationService calcDtoGenerationService;
    private final RandomTopicService randomTopicService;


    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    @Override
    public void produce() {
        String topic = randomTopicService.generate();
        CalcDto dto = calcDtoGenerationService.generate();
        log.info("<= sending {} to " + topic, writeValueAsString(dto));
        kafkaCalcTemplate.send(topic, dto);
    }

    private String writeValueAsString(CalcDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
