import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    @Test
    fun updateExisting() {
        val service = WallService()
        service.add(
            Post(
                1, 1, 2, 3, 4, "Привет!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7
            )
        )

        service.add(
            Post(
                2, 2, 2, 3, 4, "Пока!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7
            )
        )

        val update = Post(
            1, 1, 2, 3, 4, "Как дела?", 2, 2,
            true, "post", 12, true, true, false, false,
            false, true, 9
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()
        service.add(
            Post(
                1, 1, 2, 3, 4, "Привет!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7
            )
        )
        service.add(
            Post(
                2, 2, 2, 3, 4, "Пока!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7
            )
        )

        val update = Post(
            12, 2, 2, 3, 9, "Как дела?", 2, 2,
            true, "post", 12, true, true, false, false,
            false, true, 9
        )

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun add() {
        val post = Post(
            1, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7
        )
        val new = Post(
            2, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7
        )

        val result = post.copy(post.id +1)

        assertEquals(new,result)
    }
}
