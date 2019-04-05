package com.luxoft.ak47;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.awt.*;

@RestController
public class TradeEventController {

    @RequestMapping(value = "/tradeEvent/{id}",  produces = MediaType.TEXT_XML_VALUE)
    String tradeEvent(@PathVariable String id) {
        return  "<tradeEvent><id>"+ id + "</id><version>0</version></tradeEvent>";
        //add HKG only for OBS trades
    }

    // add private method to generate random currency from the list
}
