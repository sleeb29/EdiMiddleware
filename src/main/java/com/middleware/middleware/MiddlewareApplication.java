package com.middleware.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.middleware.middleware.model.ConnectorInstance;
import com.middleware.middleware.model.Middleware;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class MiddlewareApplication {

	public static void main(String[] args) throws IOException {

	    String jsonString = "{\n" +
                "    \"Middleware\" : {\n" +
                "        \"Connectors\" : [\n" +
                "            {\n" +
                "                \"protocol\" : \"https\",\n" +
                "                \"script\" : \"\",\n" +
                "                \"name\" : \"EDI850 Connector\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"protocol\" : \"https\",\n" +
                "                \"script\" : \"\",\n" +
                "                \"name\" : \"EDI820 Connector\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"ConnectorInstances\" : [\n" +
                "            {\n" +
                "                \"destination_endpoint\" : \"localhost:8080/edi850_01\",\n" +
                "                \"listening_endpoint\" : \"localhost:8081/edi850_01\",\n" +
                "                \"name\" : \"EDI850 Connector\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

		//SpringApplication.run(MiddlewareApplication.class, args);
        Middleware middleware = new ObjectMapper().readValue(jsonString, Middleware.class);

        List<ConnectorInstance> connectorInstances = middleware.getConnectorInstances();

	}
}
