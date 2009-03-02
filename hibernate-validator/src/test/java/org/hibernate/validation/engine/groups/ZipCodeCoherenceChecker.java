package org.hibernate.validation.engine.groups;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import javax.validation.Constraint;

import org.hibernate.validation.constraints.PatternValidator;

/**
 * @author Emmanuel Bernard
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ZipCodeCoherenceValidator.class)
public @interface ZipCodeCoherenceChecker {
	public abstract String message() default "{validator.zipCodeCoherenceChecker}";
	public abstract Class<?>[] groups() default {};
}