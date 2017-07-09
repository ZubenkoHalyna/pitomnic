package net.schastny.contactmanager.domain;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "PHOTO")
public class Photo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name ="photo", columnDefinition="BLOB")
    private Blob photo;

    @Column(name = "extention")
    private String extention;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "newsphoto",
            joinColumns = @JoinColumn(name = "photo_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id")
    )
    private List<News> news;

    public Photo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
