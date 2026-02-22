package io.github.jristretto.testhelpers;

import io.github.jristretto.testhelpers.StackTraceCleaner;
import static org.assertj.core.api.Assertions.fail;

/**
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class StackTraceCleanerTest {

//    @Disabled( "Think TDD" )
//    @Test
    public void seriousStackTrace() throws Throwable {
        StackTraceCleaner.executedAndRinse( () -> {
            fail( "method seriousStackTrace reached end. You know what to do." );
        } );

    }

}
