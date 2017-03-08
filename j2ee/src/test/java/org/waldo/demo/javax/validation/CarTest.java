package org.waldo.demo.javax.validation;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author waldo.wy
 * @date 2017/3/3
 */
public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test_constraint_violations() {
        Car car = new Car(null, "DD-AB-1234567890", 2, 375.5);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        constraintViolations.forEach(violation -> System.out.println(violation.getMessage()));
        assertEquals(4, constraintViolations.size());
    }

}