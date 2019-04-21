package com.consume.retialbank.creditcardservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CreditCardApplicationController {
    private final RestTemplate restTemplate;
    private final String creditcheckBaseUrl;

    public CreditCardApplicationController(RestTemplate restTemplate, @Value ("${creditcheckservice.baseurl}") String creditcheckBaseUrl) {
        this.restTemplate = restTemplate;
        this.creditcheckBaseUrl = creditcheckBaseUrl;
    }


    @PostMapping("/credit-card-app")
    public ApplyforcreditcardResponse applyforcreditcard(@RequestBody final ApplyforcreditcardRequest applyforcreditcardRequest){
            final int citizenNumber=applyforcreditcardRequest.getCitizenNumber ();
            final String uri =UriComponentsBuilder.fromHttpUrl (creditcheckBaseUrl).path ("credit-score").toUriString ();
            final CreditCheckResponse creditCheckResponse =restTemplate.postForObject (uri,new CreditCheckRequest(citizenNumber) ,CreditCheckResponse.class);

            if(creditCheckResponse.getScore ()==CreditCheckResponse.Score.HIGH &&  applyforcreditcardRequest.getCardType ()== ApplyforcreditcardRequest.CardType.GOLD){
                return  new ApplyforcreditcardResponse(ApplyforcreditcardResponse.Status.GRANTED);
            }
        throw new RuntimeException ("card and score not yet implemented");
    }

}
