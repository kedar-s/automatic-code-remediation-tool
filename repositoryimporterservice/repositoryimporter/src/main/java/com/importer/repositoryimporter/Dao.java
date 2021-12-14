/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.importer.repositoryimporter;

import java.util.List;

/**
 *
 * @author kedar
 * @param <T>
 */
public interface Dao<T>
{
    List<T> getAll();
    void save(T url);
    void update(T t, String url);
    void delete(T url);
}
