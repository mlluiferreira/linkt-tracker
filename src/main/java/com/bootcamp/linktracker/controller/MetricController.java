package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.MetricDTO;
import com.bootcamp.linktracker.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricController {

    private final LinkService linkService;

    public MetricController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetricDTO> getMetrics(@PathVariable String id) {
        MetricDTO metric = linkService.findMetricById(id);
        return ResponseEntity.ok(metric);
    }
}
