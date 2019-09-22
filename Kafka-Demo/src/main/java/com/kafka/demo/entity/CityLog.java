package com.kafka.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * City Log Table
 */
@Entity
public class CityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String severity;
    private String cityName;
    private String message;

    public CityLog() {
    }

    public CityLog(String date, String severity, String cityName, String message) {
        this.date = date;
        this.severity = severity;
        this.cityName = cityName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CityLog{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", severity='" + severity + '\'' +
                ", cityName='" + cityName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
