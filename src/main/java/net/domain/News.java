package net.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NEWS")
public class News {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "postDate")
    private Date postDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Transient
    private String postDateStr;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "newsphoto",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private List<Photo> photos;

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostDateStr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        if (postDate != null) {
            postDateStr = dateFormat.format(postDate);
            return postDateStr;
        } else return "";
    }

    public void setPostDateStr(String postDateStr) {
        this.postDateStr = postDateStr;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        dateFormat.setLenient(false);
        try {
            this.postDate = dateFormat.parse(postDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setPostDate(String postDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        dateFormat.setLenient(false);
        try {
            this.postDate = dateFormat.parse(postDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
