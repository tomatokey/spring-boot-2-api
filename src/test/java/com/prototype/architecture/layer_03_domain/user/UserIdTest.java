package com.prototype.architecture.layer_03_domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@SpringBootTest
class UserIdTest {

    @Test
    void 同一判定テスト() {
        final UserId userId1 = new UserId(1);
        final UserId userId2 = new UserId(1);
        final UserId userId3 = userId1;
        final UserId userId4 = new UserId(4);
        assertEquals(userId1, userId2);
        assertEquals(userId1, userId3);
        assertNotEquals(userId1, userId4);
    }
  
}