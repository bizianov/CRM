package project.report.resolver;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by slava23 on 12/16/2016.
 */

public class ContentResolverFactoryBean extends AbstractFactoryBean<Resolver> {

    private String contentName;

    public ContentResolverFactoryBean(String contentName) {
        this.contentName = contentName;
    }

    @Override
    public Class<?> getObjectType() {
        return Resolver.class;
    }

    @Override
    protected Resolver createInstance() throws Exception {
        if (contentName.equals("dailySalesContent")){
            return new TourResolver();
        }
        return null;
    }
}
