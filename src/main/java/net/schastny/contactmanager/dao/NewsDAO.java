package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.News;
import net.schastny.contactmanager.domain.Photo;

import java.util.List;

public interface NewsDAO {
    void add(News news);
    List<News> getAll();
    void remove(Integer id);
    News getById(Integer id);
    void update(News news);
}
