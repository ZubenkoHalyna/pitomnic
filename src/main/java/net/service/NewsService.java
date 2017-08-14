package net.service;

import net.domain.News;

import java.util.List;

public interface NewsService {
    void add(News news);
    List<News> getAll();
    void remove(Integer id);
    News getById(int id);
    void update(News news);
}
