package ru.rtmis.melfor.calcproducer.service.generator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rtmis.melfor.calcproducer.dto.CalcDto;

@Service
@RequiredArgsConstructor
public class SimpleCalcDtoGenerationService implements CalcDtoGenerationService {
    private final RandomIntService randomIntService;

    @Override
    public CalcDto generate() {
        return new CalcDto(randomIntService.generate(), randomIntService.generate());
    }
}
