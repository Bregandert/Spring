package ru.geekbrain.market.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrain.market.dto.OrderDto;
import ru.geekbrain.market.dto.ProductDto;
import ru.geekbrain.market.service.OrderService;
import ru.geekbrain.market.service.ProductService;
import ru.geekbrain.market.ws.orders.GetOrdersRequest;
import ru.geekbrain.market.ws.orders.GetOrdersResponse;
import ru.geekbrain.market.ws.products.GetProductsRequest;
import ru.geekbrain.market.ws.products.GetProductsResponse;
import ru.geekbrain.market.ws.products.ProductWS;


import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class OrdersEndpoint {

    public static final String NAMESPACE_URL = "http://ru/geekbrain/market/ws/orders";

    private OrderService orderService;

    @Autowired
    public OrdersEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrdersResponse getOrder(@RequestPayload GetOrdersRequest request)
            throws DatatypeConfigurationException {
        GetOrdersResponse response = new GetOrdersResponse();

        return response;
    }

}


