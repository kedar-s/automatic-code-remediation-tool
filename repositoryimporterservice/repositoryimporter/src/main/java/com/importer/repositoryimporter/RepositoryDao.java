/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.importer.repositoryimporter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author kedar
 */

@Component
public class RepositoryDao implements Dao<Repository>
{
    private List<Repository> repo;
    public RepositoryDao()
    {
        this.repo = new ArrayList<>();
        //repo.add(new Repository("www.google.com"));
        //repo.add(new Repository("www.facebook.com"));
    }

    @Override
    public List<Repository> getAll()
    {
        return this.repo;
    }

    @Override
    public void save(Repository url)
    {
        if(this.repo.size() > 15)
            this.repo.clear();

        this.repo.add(url);
    }

    @Override
    public void update(Repository repo, String newRepo)
    {
        repo.setUrl(newRepo);
        this.repo.add(repo);
    }

    @Override
    public void delete(Repository url)
    {
        this.repo.remove(url);
    }
    
}
