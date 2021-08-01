package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.BlogPost;
import hu.ulyssys.java.course.maven.entity.EntityType;
import hu.ulyssys.java.course.maven.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class BlogPostServiceImpl extends CoreServiceImpl<BlogPost> implements BlogPostService {

    public BlogPostServiceImpl(){
        for (int i = 0; i < 10; i++) {
            BlogPost blogPost = new BlogPost();
            blogPost.setId(Long.parseLong(i + ""));
            blogPost.setCategory(EntityType.JAVA);
            blogPost.setContent("CRUD");
            blogPost.setTitle("CRUD házi feladat");
            blogPost.setCreatedDate(new Date());
            add(blogPost);
        }
    }

    @Override
    public void update(BlogPost entity) {
        for (BlogPost blogPost : getAll()) {
            if (blogPost.getId().equals(entity.getId())){
                blogPost.setCategory(entity.getCategory());
                blogPost.setContent(entity.getContent());
                blogPost.setTitle(entity.getTitle());
                blogPost.setLastModifiedDate(new Date());
                break;
            }
        }
    }
}
