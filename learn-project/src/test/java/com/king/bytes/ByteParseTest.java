
package com.king.bytes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Yum
 * @version 1.0
 * @since 2020-11-09 16:57:47
 */
class ByteParseTest {

    /**
     * Java does not have unsigned byte
     *
     */
    @Test
    void should_return_correct_byte() {
        Byte value = Byte.valueOf("ff", 16);
        assertThat(value).isEqualTo(new Byte(Byte.parseByte("ff", 16)));
        Byte x = (byte) 0xFF;
        System.out.println(x);
    }

}
