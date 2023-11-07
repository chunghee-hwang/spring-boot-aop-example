package com.aop.annotation;

import com.aop.annotation.service.AnnotationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnnotationServiceTest {
    @Autowired
    private AnnotationService annotationService;
    @Test
    public void getSomeValueTest() {
        annotationService.getSomeValue();
    }
}
