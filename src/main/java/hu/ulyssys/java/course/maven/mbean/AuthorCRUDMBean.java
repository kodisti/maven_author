package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Author;
import hu.ulyssys.java.course.maven.service.AuthorService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class AuthorCRUDMBean implements Serializable {
    private List<Author> list;
    private Author selectedAuthor;

    private boolean inFunction;

    @Inject
    private AuthorService authorService;

    @PostConstruct
    private void init() {
        list = authorService.getAll();
        selectedAuthor = new Author();
    }

    public void save() {
        if (selectedAuthor.getId() == null) {
            selectedAuthor.setId(System.currentTimeMillis());
            selectedAuthor.setCreatedDate(new Date());
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            authorService.update(selectedAuthor);
            list = authorService.getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
        }
        selectedAuthor = new Author();
        PrimeFaces.current().executeScript("PF('authorDialog').hide()");
    }

    public void remove() {
        authorService.remove(selectedAuthor);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedAuthor = new Author();
    }

    public void initSave() {
        selectedAuthor = new Author();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public boolean isInFunction() {
        return inFunction;
    }

    public void setInFunction(boolean inFunction) {
        this.inFunction = inFunction;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
