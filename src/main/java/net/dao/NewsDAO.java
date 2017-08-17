package net.dao;

import net.model.News;

import java.util.List;

public interface NewsDAO {
    void add(News news);
    List<News> getAll();
    void remove(Integer id);
    News getById(Integer id);
    void update(News news);
}
