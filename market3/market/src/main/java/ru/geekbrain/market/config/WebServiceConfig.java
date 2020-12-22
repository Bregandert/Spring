package ru.geekbrain.market.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.geekbrain.market.endpoint.GreetingEndpoint;
import ru.geekbrain.market.endpoint.OrdersEndpoint;
import ru.geekbrain.market.endpoint.ProductsEndpoint;


@EnableWs
@Configuration
public class WebServiceConfig {

//    public static final String NAMESPACE_GREETING="http://ru/geekbrain/market/ws/greeting";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "greeting")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("GreetingPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(GreetingEndpoint.NAMESPACE_URL);
//        wsdl11Definition.setTargetNamespace(NAMESPACE_GREETING);
        wsdl11Definition.setSchema(xsdGreetingSchema());
        return wsdl11Definition;
    }

    @Bean("greetingSchema")
    public XsdSchema xsdGreetingSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ws/greeting.xsd"));
    }

    @Bean(name = "products")
    public DefaultWsdl11Definition productsWsdlDefinition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(ProductsEndpoint.NAMESPACE_URL);
        wsdl11Definition.setSchema(xsdProductsSchema());
        return wsdl11Definition;
    }

    @Bean("productsSchema")
    public XsdSchema xsdProductsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ws/products.xsd"));
    }
    @Bean(name = "orders")
    public DefaultWsdl11Definition ordersWsdlDefinition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(OrdersEndpoint.NAMESPACE_URL);
        wsdl11Definition.setSchema(xsdOrdersSchema());
        return wsdl11Definition;
    }

    @Bean("productsSchema")
    public XsdSchema xsdOrdersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ws/orders.xsd"));
    }

}