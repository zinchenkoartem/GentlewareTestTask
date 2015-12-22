package com.artem.zinchenko.dao;

import java.util.List;

public interface IDao<T> {

    T get( long id);
    List<T> getAll();
}
