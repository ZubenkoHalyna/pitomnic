package net.dao;

import net.model.Photo;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Photo photo) {
        sessionFactory.getCurrentSession().save(photo);
    }

    @SuppressWarnings("unchecked")
    public List<Photo> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Photo")
                .list();
    }

    public void remove(Integer id) {
        Photo photo = (Photo) sessionFactory.getCurrentSession().load(
                Photo.class, id);
        if (null != photo) {
            sessionFactory.getCurrentSession().delete(photo);
        }
    }

    public Photo getById(Integer id) {
        Photo photo = (Photo) sessionFactory.getCurrentSession().load(
                Photo.class, id);
        photo.getPhoto();
        return photo;
    }

    public List<Integer> getByNewsId(Integer id) {
        List<Integer> list = new ArrayList<>();
        try {
            Connection c = sessionFactory.
                    getSessionFactoryOptions().getServiceRegistry().
                    getService(ConnectionProvider.class).getConnection();
            PreparedStatement st=c.prepareStatement("SELECT photo_id From NewsPhoto where news_id=?");
            st.setInt(1,id);
            ResultSet r= st.executeQuery();
            while (r.next()) {
                list.add(r.getInt("photo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Blob createBlob(InputStream st) {
        try {
            Blob b = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(st, st.available());
            return b;
        } catch (IOException e) {
            e.printStackTrace();
            throw (new RuntimeException(e));
        }
    }
}
