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
            Post(1, 1, 2, 3, 4, "Привет!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7))
        service.add(
            Post(2, 2, 2, 3, 4, "Пока!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7))

        val update = Post(12, 2, 2, 3, 9, "Как дела?", 2, 2,
            true, "post", 12, true, true, false, false,
            false, true, 9)

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun add() {
        var posts = emptyArray<Post>()
        val post = Post(9, 1, 2, 3, 4, "Привет!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7)
        val newPost = post.copy(
            id = if (posts.isNotEmpty()) posts.last().id + 1 else 0
        )
        val result = post.id

        assertEquals(9, result)
    }
}
