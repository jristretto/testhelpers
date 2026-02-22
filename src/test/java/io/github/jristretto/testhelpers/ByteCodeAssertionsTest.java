package io.github.jristretto.testhelpers;

import io.github.jristretto.testhelpers.ByteCodeAssertions;
import io.github.jristretto.testhelpers.NaughtyCodeChecker;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author "Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}"
 */
public class ByteCodeAssertionsTest {

//@Disabled("Think TDD")
    @Test
    public void assertAReturn() throws NoSuchMethodException {
        Class<?> clz = NaughtyCodeChecker.class;
        Method checkMethod = clz.getDeclaredMethod( "check" );
        try {
            ByteCodeAssertions.assertThat( checkMethod ).avoidsCodes( "areturn" );
            fail( "should have thrown exception" );
        } catch ( AssertionError ae ) {
            // ignored
        }
//        fail( "method noLoops reached end. You know what to do." );
    }

    //@Disabled("Think TDD")
    @Test
    public void requireStreamsAndThrows() throws NoSuchMethodException {
        Class<?> clz = examples.CodePatterns.class;
        Method checkMethod = clz.getDeclaredMethod( "useStream" );

        ByteCodeAssertions.assertThat( checkMethod )
                .usesCodes( "java/util/stream/Stream", "athrow" )
                .avoidsCodes( "java/util/List.sort" );

//        fail( "method requireStreams reached end. You know what to do." );
    }
}
