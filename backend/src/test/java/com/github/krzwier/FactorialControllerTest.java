package com.github.krzwier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;



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

    @Test
    void FactorialController_Input100_ExpectHuge() throws Exception {
        MvcResult result = mockmvc.perform(get("/api/factorial?input=100")).andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("9332621544394415268169923885626670049071596826438162146859"
            + "29638952175999932299156089414639761565182862536979208272237582511852109168640"
            + "00000000000000000000000",content);
    }

    @Test
    void FactorialController_InputEmpty_Returns400() throws Exception {
        MvcResult result = mockmvc.perform(get("/api/factorial?input=")).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(400,status);
    }

    @Test
    void FactorialController_InputHello_Returns400() throws Exception {
        mockmvc.perform(get("/api/factorial?input=hello"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string(Matchers.containsString("number")));
    }

    @Test
    void FactorialController_InputNonInteger_Returns400() throws Exception {
        mockmvc.perform(get("/api/factorial?input=3.03"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string(Matchers.containsString("integer")));

    }


}
