package com.clozano.firstapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.clozano.firstapp.domain.Link;
import com.clozano.firstapp.repository.LinkRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/links")
public class LinkController {
    private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // List
    @GetMapping("/")
    public List<Link> list() {
        return this.linkRepository.findAll();
    }

    // CRUD
    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return this.linkRepository.save(link);
    }

    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return this.linkRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Optional<Link> update(@PathVariable Long id, @ModelAttribute Link link) {
        Optional<Link> linkToUpdate = this.linkRepository.findById(id);
        if (linkToUpdate.isPresent()) {
            Link existingLink = linkToUpdate.get();
            existingLink.setComments(link.getComments());
            existingLink.setCreatedBy(link.getCreatedBy());
            existingLink.setCreationDate(link.getCreationDate());
            existingLink.setLastModifiedBy(link.getLastModifiedBy());
            existingLink.setLastModifiedDate(link.getLastModifiedDate());
            existingLink.setTitle(link.getTitle());
            existingLink.setUrl(link.getUrl());
            return Optional.of(this.linkRepository.save(existingLink));
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.linkRepository.deleteById(id);
    }
}
