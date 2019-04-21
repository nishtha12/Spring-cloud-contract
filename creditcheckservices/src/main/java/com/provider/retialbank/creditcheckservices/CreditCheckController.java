package com.provider.retialbank.creditcheckservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCheckController {

        @Autowired
        private final CreditCheckService creditCheckService;

        public CreditCheckController(CreditCheckService creditCheckService) {
                this.creditCheckService = creditCheckService;
        }


        @PostMapping("/credit-score")
        public CreditCheckResponse docreditcheck(@RequestBody CreditCheckRequest creditCheckRequest){

                return  creditCheckService.doCreditCheck(creditCheckRequest.getCitizenNumber ());
                }

}
