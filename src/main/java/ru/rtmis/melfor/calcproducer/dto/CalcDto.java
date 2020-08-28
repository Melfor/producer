package ru.rtmis.melfor.calcproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CalcDto extends AbstractDto{
    private Integer first;
    private Integer second;
}
