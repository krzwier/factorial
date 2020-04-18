package com.github.krzwier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FactorialControllerTest {
    @Autowired
    MockMvc mockmvc;

    @Test
    void FactorialController_Input5_Returns200() throws Exception {
        MvcResult result = mockmvc.perform(get("/api/factorial?input=5")).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void FactorialController_Input5_Expect120() throws Exception {
        MvcResult result = mockmvc.perform(get("/api/factorial?input=5")).andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("120",content);
    }

    @Test
    void FactorialController_Input100_Returns200() throws Exception {
        MvcResult result = mockmvc.perform(get("/api/factorial?input=100")).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }


}
