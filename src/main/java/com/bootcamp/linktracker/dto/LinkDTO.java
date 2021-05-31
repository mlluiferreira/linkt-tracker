package com.bootcamp.linktracker.dto;

public class LinkDTO {
    private String id;

    private String url;

    private MetricDTO metric;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MetricDTO getMetric() {
        return metric;
    }

    public void setMetric(MetricDTO metric) {
        this.metric = metric;
    }
}
