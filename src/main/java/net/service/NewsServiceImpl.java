package net.service;

import net.dao.NewsDAO;
import net.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Transactional
    public void add(News news) {
        newsDAO.add(news);
    }

    @Transactional
    public List<News> getAll() {
        return newsDAO.getAll();
    }

    @Transactional
    public void remove(Integer id) {
        newsDAO.remove(id);
    }

    @Transactional
    public News getById(int id) {
        return newsDAO.getById(id);
    }

    @Transactional
    public void update(News news) {
        newsDAO.update(news);
    }
}
