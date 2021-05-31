package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.utils.LinkUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository {

    private Map<String, Link> linkRepo = new HashMap<>();

    public Link save(Link link) {
        link.setId(LinkUtil.generateLinkId());
        linkRepo.put(link.getId(), link);
        return findById(link.getId());
    }

    public Link findById(String id) {
        return linkRepo.getOrDefault(id, null);
    }

    public List<Link> getAll() {
        return new ArrayList<>(linkRepo.values());
    }

    public Link update(Link link) {
        return linkRepo.replace(link.getId(), link);
    }

    public void deleteById(String id) {
        linkRepo.remove(id);
    }
}
