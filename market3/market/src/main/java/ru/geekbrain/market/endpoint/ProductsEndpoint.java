package ru.geekbrain.market.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrain.market.dto.ProductDto;
import ru.geekbrain.market.service.ProductService;
import ru.geekbrain.market.ws.products.GetProductsRequest;
import ru.geekbrain.market.ws.products.GetProductsResponse;
import ru.geekbrain.market.ws.products.ProductWS;


import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class ProductsEndpoint {

    public static final String NAMESPACE_URL = "http://ru/geekbrain/market/ws/products";

    private final ProductService productService;

    public ProductsEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getGreeting(@RequestPayload GetProductsRequest request)
            throws DatatypeConfigurationException {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll()
                .forEach(dto -> response.getProducts().add(createProductWS(dto)));
        return response;
    }

    private ProductWS createProductWS(ProductDto dto){
        ProductWS ws = new ProductWS();
        ws.setId(dto.getId());
        ws.setPrice(dto.getPrice());
        ws.setTitle(dto.getTitle());
        return ws;
    }
}