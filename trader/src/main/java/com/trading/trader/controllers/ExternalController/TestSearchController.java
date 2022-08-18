package com.trading.trader.controllers.ExternalController;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.sun.xml.bind.v2.model.core.TypeRef;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class TestSearchController {
    public static void main(String[] args) throws JsonProcessingException {
        Match result = SearchController.getStockName("microsoft");
        System.out.println(result);

//
//        JsonArray inputArray = new JSONPObject(result);

    }
}
