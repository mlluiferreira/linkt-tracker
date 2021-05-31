package com.bootcamp.linktracker.mapper;

import com.bootcamp.linktracker.dto.MetricDTO;
import com.bootcamp.linktracker.model.Metric;

public class MetricMapper {
    public static Metric mapFromDTO(MetricDTO metricDTO) {
        Metric metric = new Metric();
        metric.setCounter(metricDTO.getCounter());
        return metric;
    }

    public static MetricDTO mapToDTO(Metric metric) {
        MetricDTO metricDTO = new MetricDTO();
        metricDTO.setCounter(metric.getCounter());
        return metricDTO;
    }
}
