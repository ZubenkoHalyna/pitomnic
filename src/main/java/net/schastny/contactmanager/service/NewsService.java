package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.News;
import net.schastny.contactmanager.domain.Role;

import java.util.List;

public interface NewsService {
    void add(News news);
    List<News> getAll();
    void remove(Integer id);
    News getById(int id);
    void update(News news);
}
