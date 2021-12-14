/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.importer.repositoryimporter;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author kedar
 */

@RestController
public class RepositoryResource
{
    @Autowired
    private RepositoryDao service;
    
    @Autowired
    private Importer repoImporter;
    
    @GetMapping("/repos")
    public List<Repository> retrieveURLs()
    {
        return service.getAll();
    }

    @GetMapping("/testMe")
    public String testMethod()
    {
        return "TEST SUCCESSFUL";
    }
    
    @PostMapping("/repos")
    public ResponseEntity createRepo(@RequestBody Repository repo)
    {
        service.save(repo);
        repoImporter.clone(repo.getUrl());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        
        return ResponseEntity.created(location).build();
    }
}
