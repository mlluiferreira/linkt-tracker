package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.CreateLinkDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.MetricDTO;
import com.bootcamp.linktracker.exception.InvalidUrlException;
import com.bootcamp.linktracker.exception.NotFoundUrl;
import com.bootcamp.linktracker.mapper.LinkMapper;
import com.bootcamp.linktracker.mapper.MetricMapper;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.LinkRepository;
import com.bootcamp.linktracker.utils.LinkUtil;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkDTO createLink(CreateLinkDTO createLinkDTO) {
        if (!LinkUtil.isValid(createLinkDTO.getUrl()))
            throw new InvalidUrlException("Invalid Url " + createLinkDTO.getUrl(), createLinkDTO);

        Link link = LinkMapper.mapperFromCreateDTO(createLinkDTO);

        return LinkMapper.mapToDTO(linkRepository.save(link));
    }

    public LinkDTO findById(String id) {
        Link link = linkRepository.findById(id);

        if (link == null)
            throw new NotFoundUrl("Not found url", id);

        link.getMetric().addOne();
        link = linkRepository.update(link);

        return LinkMapper.mapToDTO(link);
    }

    public MetricDTO findMetricById(String id) {
        Link link = linkRepository.findById(id);
        if (link == null)
            throw new NotFoundUrl("Not found url", id);

        return MetricMapper.mapToDTO(link.getMetric());
    }

    public void deleteLink(String id) {
        if (findById(id) != null)
            linkRepository.deleteById(id);
    }
}
