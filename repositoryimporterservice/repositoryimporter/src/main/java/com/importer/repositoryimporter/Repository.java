/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.importer.repositoryimporter;

/**
 *
 * @author kedar
 */
public class Repository
{
    private String url;
    
    protected Repository()
    {
        
    }
    
    public Repository(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "Repository{" + "url=" + url + '}';
    }
    
    
}
