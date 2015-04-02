package org.sample.util;

import org.sample.client.ApplicationLog;
import org.sample.client.CustomerLog;
import org.sample.client.CustomerLogStatistics;
import org.sample.client.ParameterName;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Mohamed Mekkawy on 18/03/2015.
 */
public class Statistics {

    final static RestTemplate restTemplate = new RestTemplate();

    /*
     * Service URL of most visited products
     */
    final static String MOST_VISITED_PRODUCTS_URL = "http://localhost:8080/statistics/mostVisitedProducts";

    /**
     * service URL of customer recommended product.
     */
    final static String CUSTOMER_RECOMMENDED_PRODUCT = "http://localhost:8080/statistics/recommendedProduct";

    /*
     * Service URL of customer messages
     */
    final static String ALL_CUSTOMER_LOGS = "http://localhost:8080/statistics/allCustomerLogs";

    /**
     * service URL of search all application logs.
     */
    final static String SEARCH_APP_LOGS = "http://localhost:8080/statistics/searchAppLogs";

    /**
     * service URL of search all customer logs.
     */
    final static String SEARCH_CUSTOMER_LOGS = "http://localhost:8080/statistics/searchCustomerLogs";

    /*
     * Service URL of app messages
     */
    final static String ALL_APP_LOGS = "http://localhost:8080/statistics/allAppLogs";

    public static CustomerLogStatistics[] mostVisitedProducts(String customerId) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(MOST_VISITED_PRODUCTS_URL)
                .queryParam("customerId", customerId)
                .build();

        return restTemplate.getForObject(uriComponents.toUri(), CustomerLogStatistics[].class);
    }

    public static CustomerLogStatistics recommendedProduct(String customerId) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(CUSTOMER_RECOMMENDED_PRODUCT)
                .queryParam("customerId", customerId)
                .build();

        return restTemplate.getForObject(uriComponents.toUri(), CustomerLogStatistics.class);
    }

    public static CustomerLog[] allCustomerLogs(String customerId) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(ALL_CUSTOMER_LOGS)
                .queryParam(ParameterName.CUSTOMER_ID, customerId)
                .build();

        return restTemplate.getForObject(uriComponents.toUri(), CustomerLog[].class);
    }

    public static ApplicationLog[] allAppLogs(String appName) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(ALL_APP_LOGS)
                .queryParam(ParameterName.APP_NAME, appName)
                .build();

        return restTemplate.getForObject(uriComponents.toUri(), ApplicationLog[].class);
    }

    public static ApplicationLog[] searchAppLogs(String... text) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(SEARCH_APP_LOGS);
        for (int i = 0 ; i < text.length; i++){
            uriComponentsBuilder.queryParam("param"+i, text[i]);
        }

        return restTemplate.getForObject(uriComponentsBuilder.build().toUri(), ApplicationLog[].class);
    }

    public static CustomerLog[] searchCustomerLogs(String... text) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(SEARCH_CUSTOMER_LOGS);
        for (int i = 0 ; i < text.length; i++){
            uriComponentsBuilder.queryParam("param"+i, text[i]);
        }

        return restTemplate.getForObject(uriComponentsBuilder.build().toUri(), CustomerLog[].class);
    }
}
