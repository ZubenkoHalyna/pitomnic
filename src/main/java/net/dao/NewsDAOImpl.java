package net.dao;

import net.model.News;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO{

    @Autowired
    private SessionFactory sessionFactory;
    org.hibernate.Session s;

    public void add(News news) {
        sessionFactory.getCurrentSession().save(news);
    }

    @SuppressWarnings("unchecked")
    public List<News> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from News")
                .list();
    }

    public void remove(Integer id) {
        News news = (News) sessionFactory.getCurrentSession().load(
                News.class, id);
        if (null != news) {
            sessionFactory.getCurrentSession().delete(news);
        }
    }

    public News getById(Integer id) {
        News news = (News) sessionFactory.getCurrentSession().load(
                News.class, id);
        news.getTitle();
        news.getDescription();
        return news;
    }

    @Override
    public void update(News news) {
        News n = (News) sessionFactory.getCurrentSession().load(
                News.class, news.getId());
        n.setTitle(news.getTitle());
        n.setDescription(news.getDescription());
        sessionFactory.getCurrentSession().update(n);
    }

}
