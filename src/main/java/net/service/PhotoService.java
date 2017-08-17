package net.service;

import net.model.Photo;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

public interface PhotoService {
    void add(Photo photo);
    List<Photo> getAll();
    void remove(Integer id);
    Photo getById(int id);
    Blob createBlob(InputStream st);
    List<Integer> getByNewsId(Integer id);
}
