package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invalidate")
public class InvalidateController {

    private final LinkService linkService;

    public InvalidateController(LinkService linkService) {
        this.linkService = linkService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable String id) {
        linkService.deleteLink(id);
        return ResponseEntity.ok().build();
    }
}
