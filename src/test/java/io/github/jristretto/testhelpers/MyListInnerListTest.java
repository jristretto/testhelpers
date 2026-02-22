package io.github.jristretto.testhelpers;

import io.github.jristretto.testhelpers.NaughtyCodeChecker;
import examples.MyListInnerList;
import static io.github.jristretto.testhelpers.NaughtyCodeChecker.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hom
 */
public class MyListInnerListTest {

    @Test
    public void testOwnListNotNaughty() {
        MyListInnerList<Integer> l = new MyListInnerList<>();
        NaughtyCodeChecker nl = new NaughtyCodeChecker( NO_UTIL_LIST, l );
//        System.out.println( "nc.evidence() = " + nl.evidence() );
        assertThat( nl.isNaughty() ).as( "Naughty" ).isTrue();

//        fail( "testOwnListNotNaughty reached it's and. You will know what to do." );
    }
}
