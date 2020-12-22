package ru.geekbrain.market.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrain.market.config.WebServiceConfig;
import ru.geekbrain.market.service.GreetingService;
import ru.geekbrain.market.ws.greeting.GetGreetingRequest;
import ru.geekbrain.market.ws.greeting.GetGreetingResponse;


import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class GreetingEndpoint {

    public static final String NAMESPACE_URL = "http://ru/geekbrain/market/ws/greeting";

private GreetingService greetingService;

    @Autowired
    public GreetingEndpoint(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getGreetingRequest")
    @ResponsePayload
    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request)
            throws DatatypeConfigurationException {
        GetGreetingResponse response = new GetGreetingResponse();

        response.setGreeting(greetingService.generateGreeting(request.getName()));

        return response;
    }

//    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_GREETING, localPart = "getGreetingRequest")
//    @ResponsePayload
//    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request)
//            throws DatatypeConfigurationException {
//        GetGreetingResponse response = new GetGreetingResponse();
//
//        response.setGreeting(greetingService.generateGreeting(request.getName()));
//
//        return response;
//    }

}