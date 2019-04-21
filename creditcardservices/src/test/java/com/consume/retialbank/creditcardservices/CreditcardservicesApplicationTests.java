package com.consume.retialbank.creditcardservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids="com.provider.retialbank:creditcheckservices:+:stubs:8080",workOffline = true)
public class CreditcardservicesApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoads() throws Exception {
	mockMvc.perform(
			post("/credit-card-app")
			    .contentType (APPLICATION_JSON)
			    .content("{"+
					"\"citizenNumber\":1234,"+
					"\"cardType\":\"GOLD\""+
					"}"
					)  )
			.andDo (print())
			.andExpect(status().isOk ())
			.andExpect(content ().json("{"+
                    "\"status\":\"GRANTED\"" +
			            "}"))
            .andExpect (content ().contentTypeCompatibleWith (APPLICATION_JSON));

	}

}
