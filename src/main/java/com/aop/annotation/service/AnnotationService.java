package com.aop.annotation.service;

import com.aop.annotation.anno.Custom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnnotationService {
    @Custom(firstValue = "firstValue", secondValue = "secondValue")
    public String getSomeValue() {
        return "some";
    }
}
