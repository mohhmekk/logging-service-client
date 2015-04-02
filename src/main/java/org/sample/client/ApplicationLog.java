package org.sample.client;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Represents Application log messages.
 * <p/>
 * Created by Mohamed Mekkawy on 17/03/2015.
 */
public class ApplicationLog {

    private Float sore;

    private String id;

    private String message;

    private Date time;

    private String level;

    private String applicationName;

    private String loggerName;

    private List<String> traceback;

    private ApplicationLogType applicationLogType;

    private String threadNo;

    private String moduleName;

    public ApplicationLog() {
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

    public ApplicationLogType getApplicationLogType() {
        return applicationLogType;
    }

    public void setApplicationLogType(ApplicationLogType applicationLogType) {
        this.applicationLogType = applicationLogType;
    }

    public String getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(String threadNo) {
        this.threadNo = threadNo;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "ApplicationLog{" +
                "sore=" + sore +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", level='" + level + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", applicationLogType=" + applicationLogType +
                ", threadNo='" + threadNo + '\'' +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
}
