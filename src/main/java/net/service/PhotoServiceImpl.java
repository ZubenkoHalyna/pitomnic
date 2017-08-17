package net.service;

import net.dao.PhotoDAO;
import net.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoDAO photoDAO;

    @Transactional
    public void add(Photo photo) {
        photoDAO.add(photo);
    }

    @Transactional
    public List<Photo> getAll() {
        return photoDAO.getAll();
    }

    @Transactional
    public void remove(Integer id) {
        photoDAO.remove(id);
    }

    @Transactional
    public Photo getById(int id) {
        return photoDAO.getById(id);
    }

    @Transactional
    public  Blob createBlob(InputStream st){
        return photoDAO.createBlob(st);
    }

    @Transactional
    public List<Integer> getByNewsId(Integer id) {
        return photoDAO.getByNewsId(id);
    }
}
