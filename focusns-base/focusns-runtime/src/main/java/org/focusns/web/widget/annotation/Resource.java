package org.focusns.web.widget.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Resource {

    public enum Scope {
		PARAMETER, REQUEST, SESSION, APPLICATION
	}
    
    String[] required();
    
    Scope scope() default Scope.PARAMETER;
    
}
