package org.sample.client;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Represents Customer log messages.
 * <p/>
 * Created by Mohamed Mekkawy on 17/03/2015.
 */
public class CustomerLog {

    private String id;

    private Float sore;

    private String message;

    private Date time;

    private String level;

    private String applicationName;

    private String loggerName;

    private List<String> traceback;

    private String customerId;

    private CustomerLogType customerLogType;

    private String productId;

    private String searchTerm;

    private String currentPage;

    public CustomerLog() {
    }

    public Float getSore() {
        return sore;
    }

    public void setSore(Float sore) {
        this.sore = sore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public List<String> getTraceback() {
        return traceback;
    }

    public void setTraceback(List<String> traceback) {
        this.traceback = traceback;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerLogType getCustomerLogType() {
        return customerLogType;
    }

    public void setCustomerLogType(CustomerLogType customerLogType) {
        this.customerLogType = customerLogType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "CustomerLog{" +
                ", sore=" + sore +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", level='" + level + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerLogType=" + customerLogType +
                ", productId='" + productId + '\'' +
                ", searchTerm='" + searchTerm + '\'' +
                ", currentPage='" + currentPage + '\'' +
                '}';
    }
}
