package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Photo;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

public interface PhotoDAO {
    void add(Photo photo);
    List<Photo> getAll();
    void remove(Integer id);
    Photo getById(Integer id);
    Blob createBlob(InputStream st);
    List<Integer> getByNewsId(Integer id);
}
