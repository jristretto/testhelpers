package io.github.jristretto.testhelpers;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

/**
 * Clean stack traces from reference to undesired  packages.
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class StackTraceCleaner {

    static Set<String> forbiddenPrefixes = new TreeSet<>();

    static {
        forbiddenPrefixes.addAll( Arrays.asList(
                "org.junit"
        ) );
    }

    public static StackTraceElement[] filter( Throwable t ) {
        return Stream.of( t.getStackTrace() )
                .filter( s -> !forbiddenPrefixes.contains( s.toString() ) )
                .peek( System.out::println )
                .toArray( StackTraceElement[]::new );
    }

    public static <T extends Throwable> T trimStackTrace( T t ) {
        t.setStackTrace( filter( t ) );
        return t;
    }

    public static void executedAndRinse( ThrowingCallable code ) throws Throwable {
        try {
            code.call();
        } catch ( Throwable t ) {
            throw trimStackTrace( t );
        }
    }

}
