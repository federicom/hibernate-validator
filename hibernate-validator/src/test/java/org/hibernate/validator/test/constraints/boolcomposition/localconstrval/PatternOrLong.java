/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and/or its affiliates, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hibernate.validator.test.constraints.boolcomposition.localconstrval;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ConstraintComposition;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.hibernate.validator.constraints.CompositionType.OR;

/**
 * Test constraint for HV-390.
 *
 * Uses the same constraintValidator as SmallString, but does not negate the result.
 * Hence it tests that a string is long at least 9 characters (or that it matches the given pattern).
 *
 * @author Federico Mancini
 * @author Dag Hovland
 */

@ConstraintComposition(OR)
@Pattern(regexp = "W{4}")
//@ReportAsSingleViolation
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {LongStringValidator.class })
public @interface PatternOrLong {
	public abstract String message() default "Both Pattern and LongString failed";

	public abstract Class<?>[] groups() default { };

	public abstract Class<? extends Payload>[] payload() default { };
}
