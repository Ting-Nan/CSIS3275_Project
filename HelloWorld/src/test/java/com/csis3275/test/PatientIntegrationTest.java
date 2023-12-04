package com.csis3275.test;

import com.csis3275.controller.PatientController_ths_01;
import com.csis3275.model.PatientRepository_ths_01;
import com.csis3275.model.PatientService_ths_01;
import com.csis3275.model.Patient_ths_01;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PatientRepository_ths_01 patientRepository;

    @Autowired
    private PatientService_ths_01 patientService;

    @Test
    @Transactional
    void testCRUDOperations() throws Exception {
        // Create
        Patient_ths_01 patient = new Patient_ths_01();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setEmail("john.doe@example.com");
        patient.setHeight(175);
        patient.setWeight(70);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/patients/add")
                .param("firstName", patient.getFirstName())
                .param("lastName", patient.getLastName())
                .param("email", patient.getEmail())
                .param("height", String.valueOf(patient.getHeight()))
                .param("weight", String.valueOf(patient.getWeight())))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        // Extract the patient ID from the redirected URL
        String redirectedUrl = result.getResponse().getRedirectedUrl();
        String[] urlParts = redirectedUrl.split("/");
        Long patientId = parsePatientId(urlParts[urlParts.length - 1]);

        // Read
        Patient_ths_01 retrievedPatient = patientService.getPatient(patientId);
        Assertions.assertNotNull(retrievedPatient);
        Assertions.assertEquals("John", retrievedPatient.getFirstName());
        Assertions.assertEquals("Doe", retrievedPatient.getLastName());
        Assertions.assertEquals("john.doe@example.com", retrievedPatient.getEmail());
        Assertions.assertEquals(175, retrievedPatient.getHeight());
        Assertions.assertEquals(70, retrievedPatient.getWeight());

        // Update
        retrievedPatient.setWeight(72);
        mockMvc.perform(MockMvcRequestBuilders.post("/patients/edit")
                .param("id", String.valueOf(retrievedPatient.getId()))
                .param("firstName", retrievedPatient.getFirstName())
                .param("lastName", retrievedPatient.getLastName())
                .param("email", retrievedPatient.getEmail())
                .param("height", String.valueOf(retrievedPatient.getHeight()))
                .param("weight", String.valueOf(retrievedPatient.getWeight())))
                .andExpect(status().is3xxRedirection());

        // Verify the update
        Patient_ths_01 updatedPatient = patientService.getPatient(patientId);
        Assertions.assertEquals(72, updatedPatient.getWeight());

        // Delete
        mockMvc.perform(MockMvcRequestBuilders.get("/patients/delete")
                .param("id", String.valueOf(updatedPatient.getId())))
                .andExpect(status().is3xxRedirection());

        // Verify the delete
        Assertions.assertFalse(patientRepository.findById(updatedPatient.getId()).isPresent());
    }
    
    private Long parsePatientId(String patientIdString) {
        try {
            if ("list".equalsIgnoreCase(patientIdString)) {
                throw new RuntimeException("Invalid patient ID: " + patientIdString);
            }
            return Long.parseLong(patientIdString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid patient ID format: " + patientIdString, e);
        }
    }
}
