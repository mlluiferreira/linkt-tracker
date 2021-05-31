package com.bootcamp.linktracker.mapper;

import com.bootcamp.linktracker.dto.CreateLinkDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.model.Metric;

public class LinkMapper {
    public static Link mapperFromCreateDTO(CreateLinkDTO linkDTO) {
        Link link = new Link();
        link.setUrl(linkDTO.getUrl());
        link.setMetric(new Metric());
        return link;
    }

    public static LinkDTO mapToDTO(Link link) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setId(link.getId());
        linkDTO.setUrl(link.getUrl());
        linkDTO.setMetric(MetricMapper.mapToDTO(link.getMetric()));
        return linkDTO;
    }
}
