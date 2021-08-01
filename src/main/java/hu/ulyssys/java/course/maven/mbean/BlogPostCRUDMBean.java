package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.BlogPost;
import hu.ulyssys.java.course.maven.entity.EntityType;
import hu.ulyssys.java.course.maven.service.BlogPostService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class BlogPostCRUDMBean implements Serializable {
    private List<BlogPost> list;
    private BlogPost selectedBlogPost;

    private boolean inFunction;

    @Inject
    private BlogPostService blogPostService;

    @PostConstruct
    private void init(){
        list = blogPostService.getAll();
        selectedBlogPost = new BlogPost();
    }

    public EntityType[] getEntityTypes() {
        return EntityType.values();
    }

    public void save(){
        if (selectedBlogPost.getId() == null){
            selectedBlogPost.setId(System.currentTimeMillis());
            selectedBlogPost.setCreatedDate(new Date());
            blogPostService.add(selectedBlogPost);
            list = blogPostService.getAll();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Sikeres hozzáadás"));
        }else {
            blogPostService.update(selectedBlogPost);
            list = blogPostService.getAll();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Sikeres módosítás"));
        }
        selectedBlogPost = new BlogPost();
        PrimeFaces.current().executeScript("PF('blogpostDialog').hide()");
    }

    public void remove(){
        blogPostService.remove(selectedBlogPost);
        list = blogPostService.getAll();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedBlogPost = new BlogPost();
    }

    public void initSave(){
        selectedBlogPost = new BlogPost();
        inFunction = true;
    }

    public void initEdit(){
        inFunction = true;
    }

    public List<BlogPost> getList() {
        return list;
    }

    public void setList(List<BlogPost> list) {
        this.list = list;
    }

    public BlogPost getSelectedBlogPost() {
        return selectedBlogPost;
    }

    public void setSelectedBlogPost(BlogPost selectedBlogPost) {
        this.selectedBlogPost = selectedBlogPost;
    }

    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public void setInFunction(boolean inFunction) {
        this.inFunction = inFunction;
    }
}
