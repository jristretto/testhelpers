package io.github.jristretto.testhelpers;

import io.github.jristretto.testhelpers.NFTestHelpers;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static io.github.jristretto.testhelpers.NFTestHelpers.checkField;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pieter van den Hombergh (879417) {@code pieter.van.den.hombergh@gmail.com}
 */
public class NFTestHelpersIT {

    Car c = new Car( "red", LocalDate.MIN, "12-AB-34", 500.0D );
    Class<?> clz = c.getClass();

    @Test
    public void testMissingPrivateFinal() {
        try {
            checkField( clz, Modifier.FINAL, String.class, "color" );
            fail( "should fail" );
        } catch ( Throwable t ) {
            assertThat( t.getClass() ).as( "assertion did not fail" ).isEqualTo( AssertionError.class );
        }
    }

    @Test
    public void testWrongType() {
        try {
            checkField( clz, Modifier.FINAL, int.class, "price" );
            fail( "should fail" );
        } catch ( Throwable t ) {
            System.out.println( "t = " + t );
            assertThat( t ).as( "wrong exception type" ).isInstanceOf( AssertionError.class );
        }
    }

    @Test
    public void testCheckIsOrImplements() {
        assertThat( NFTestHelpers.
                checkIsOrImplements( ArrayList.class,
                        List.class
                ) ).as( "ArrayList is supposed to be a List" ).isTrue();
    }

    @Test
    public void testAssertIsOrImplements() {
        NFTestHelpers.assertIsOrImplements( "ArrayList is supposed to be a List", ArrayList.class, List.class );
    }

    //@Ignore
    @Test
    public void testMethod() {
        String safeToString = NFTestHelpers.safeToString( new BrokenToString() );
        assertThat( safeToString )
                .isNotNull()
                .isNotEmpty();
    }

}
