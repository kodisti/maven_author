package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.EntityType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EntityTypeCRUDMBean {

    public EntityType[] getEntityTypes() {
        return EntityType.values();
    }

}
