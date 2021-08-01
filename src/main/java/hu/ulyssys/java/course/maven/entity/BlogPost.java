package hu.ulyssys.java.course.maven.entity;

import java.util.Date;

public class BlogPost extends AbstractEntity{
    private String title;
    private String content;
    private EntityType category;
    private Date publishedDate;

    public BlogPost(){

    }

    public BlogPost(Long id, Date createdDate, Date lastModifiedDate, String title, String content, EntityType category, Date publishedDate) {
        super(id, createdDate, lastModifiedDate);
        this.title = title;
        this.content = content;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EntityType getCategory() {
        return category;
    }

    public void setCategory(EntityType category) {
        this.category = category;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
