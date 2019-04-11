package com.luxoft.ak47;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class TradeEventController {

    @RequestMapping(value = "/tradeEvent/{id}",  produces = MediaType.TEXT_XML_VALUE)
    String tradeEvent(@PathVariable String id) {
        String tradeLocationTag;
        if (id.toLowerCase().startsWith("obs") ) {
            tradeLocationTag = "<tradeLocation>HKG</tradeLocation>";
        } else {
            tradeLocationTag = "";
        }
        return  "<tradeEvent><id>"+ id + "</id><version>0</version>" + tradeLocationTag +"<currency>" + getRandomCurrency() + "</currency></tradeEvent>";
        //add HKG only for OBS trades
    }

    // add private method to generate random currency from the list dc
    private String getRandomCurrency() {
        List<String> currencies = Arrays.asList("USD", "EUR", "HKG", "PLN");
        return currencies.get(new Random().nextInt(currencies.size()));
    }


}
