package com.csis3275.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SymptomServiceImpl_ths_01 implements SymptomService_ths_01 {
	@Override
    public List<String> getAllSymptoms() {
        
        return Arrays.asList("Headache", "Cough", "Fever", "Fatigue", "Shortness of Breath");
    }

}
