import junit.framework.TestCase;
import org.junit.Test;
import pt.brunohorta.entities.Car;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by BrunoHorta on 12/04/15.
 */
public class CarModelTest extends TestCase {

    @Test
    public void testNull(){
        Car car = new Car("HONDa", "Model");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Logger logger = Logger.getAnonymousLogger();

        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        for (ConstraintViolation<Car> violation : violations) {
            logger.info(violation.getPropertyPath()+" - "+violation.getMessage());
        }
        assertEquals(1,violations.size());

    }
}
