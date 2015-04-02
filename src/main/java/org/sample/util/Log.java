package org.sample.util;

import org.sample.client.ApplicationLogType;
import org.sample.client.CustomerLogType;
import org.sample.client.ParameterName;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Mohamed Mekkawy on 18/03/2015.
 */
public class Log {

    final static RestTemplate restTemplate = new RestTemplate();

    /*
     *Application log service
     */
    final static String APP_LOG_URL = "http://localhost:8080/log/app";

    /*
     *Customer log service
     */
    final static String CUSTOMER_LOG_URL = "http://localhost:8080/log/customer";

    public static void customerLog(String appName, String customerId, String message, String level, List<String> trace,
                                   CustomerLogType customerLogType, String productId, String currentPage, String searchTerm) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(CUSTOMER_LOG_URL)
                .queryParam(ParameterName.APP_NAME, appName)
                .queryParam(ParameterName.CUSTOMER_ID, customerId)
                .queryParam(ParameterName.LEVEL, level)
                .queryParam(ParameterName.MESSAGE, message)
                .queryParam(ParameterName.TRACE, trace)
                .queryParam(ParameterName.LOG_TYPE, customerLogType.name())
                .queryParam(ParameterName.PRODUCT_ID, productId)
                .queryParam(ParameterName.CURRENT_PAGE, currentPage)
                .queryParam(ParameterName.SEARCH_TERM, searchTerm)
                .build();

        restTemplate.getForObject(uriComponents.toUri(), String.class);
    }

    public static void appLog(String appName, String moduleName, String message, String level, List<String> trace,
                              ApplicationLogType applicationLogType, String threadNo) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(APP_LOG_URL)
                .queryParam(ParameterName.APP_NAME, appName)
                .queryParam(ParameterName.MODULE_NAME, moduleName)
                .queryParam(ParameterName.LEVEL, level)
                .queryParam(ParameterName.MESSAGE, message)
                .queryParam(ParameterName.TRACE, trace)
                .queryParam(ParameterName.LOG_TYPE, applicationLogType.name())
                .queryParam(ParameterName.THREAD_NO, threadNo)
                .build();

        restTemplate.getForObject(uriComponents.toUri(), String.class);
    }
}
