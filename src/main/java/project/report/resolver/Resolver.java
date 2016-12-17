package project.report.resolver;

import java.util.List;

/**
 * Created by slava23 on 12/16/2016.
 */
public interface Resolver <T> {
    List<T> resolve(String content);
}
