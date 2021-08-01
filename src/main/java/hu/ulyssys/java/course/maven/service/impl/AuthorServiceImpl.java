package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Author;
import hu.ulyssys.java.course.maven.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class AuthorServiceImpl extends CoreServiceImpl<Author> implements AuthorService {

    public AuthorServiceImpl(){
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setId(Long.parseLong(i + ""));
            author.setFirstName("Pista");
            author.setLastName("Kis");
            author.setUsername("pityu");
            author.setCreatedDate(new Date());
            add(author);
        }
    }

    @Override
    public void update(Author entity) {
        for (Author author : getAll()) {
            if (author.getId().equals(entity.getId())){
                author.setFirstName(entity.getFirstName());
                author.setLastName(entity.getLastName());
                author.setUsername(entity.getUsername());
                author.setLastModifiedDate(new Date());
                break;
            }
        }
    }
}
