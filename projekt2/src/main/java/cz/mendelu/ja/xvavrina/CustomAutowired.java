package cz.mendelu.ja.xvavrina;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * My own implementation of Autowired, can be assigned to METHOD, CONSTRUCTOR or FIELD
 */
@Target({METHOD,CONSTRUCTOR,FIELD})
@Retention(RUNTIME)
@Documented
public @interface CustomAutowired {
}
