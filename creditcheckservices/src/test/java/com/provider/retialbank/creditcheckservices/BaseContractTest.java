package com.provider.retialbank.creditcheckservices;

import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static com.provider.retialbank.creditcheckservices.CreditCheckResponse.Score.HIGH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {
    @Before
    public void setup(){
        final CreditCheckService creditCheckService = mock(CreditCheckService.class);
        when(creditCheckService.doCreditCheck (1234)).thenReturn(new CreditCheckResponse(HIGH));
        RestAssuredMockMvc.standaloneSetup (new CreditCheckController(new CreditCheckService ()));
    }



}
