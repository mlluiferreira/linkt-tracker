package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.CreateLinkDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("link")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkDTO> createLink(@RequestBody CreateLinkDTO createLinkDTO) {
        return ResponseEntity.ok(linkService.createLink(createLinkDTO));
    }

    @GetMapping("/{id}")
    public RedirectView redirectTo(@PathVariable String id) {
        return new RedirectView(linkService.findById(id).getUrl());
    }
}
