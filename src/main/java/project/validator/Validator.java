package project.validator;

import java.text.ParseException;

/**
 * Created by slava23 on 11/29/2016.
 */
public interface Validator<T, E> {
    T validate(E e) throws Exception;
}
