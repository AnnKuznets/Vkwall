import org.junit.Assert
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
                false, true, 7, null, arrayOf()
            )
        )

        service.add(
            Post(
                2, 2, 2, 3, 4, "Пока!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7, null, arrayOf()
            )
        )

        val update = Post(
            1, 1, 2, 3, 4, "Как дела?", 2, 2,
            true, "post", 12, true, true, false, false,
            false, true, 9, null, arrayOf()
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
                false, true, 7, null, arrayOf()
            )
        )
        service.add(
            Post(
                2, 2, 2, 3, 4, "Пока!", 1, 2,
                true, "post", 12, true, true, false, false,
                false, true, 7, null, arrayOf()
            )
        )

        val update = Post(
            12, 2, 2, 3, 9, "Как дела?", 2, 2,
            true, "post", 12, true, true, false, false,
            false, true, 9, null, arrayOf()
        )

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun add() {
        val post = Post(
            1, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7, null, arrayOf()
        )
        val new = Post(
            2, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7, null, arrayOf()
        )

        val result = post.copy(post.id + 1)

        assertEquals(new, result)
    }

    @Test
    fun shouldNotThrow() {
        val post = Post(
            1, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7, null, arrayOf()
        )
        val comment = Comment(
            1, 2, 11233333, "Огонь!", 3, 1
        )

        assertEquals(post.id, comment.postId)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(
            1, 2, 2, 3, 4, "Пока!", 1, 2,
            true, "post", 12, true, true, false, false,
            false, true, 7, null, arrayOf()
        )
        val comment = Comment(
            2, 2, 11233333, "Огонь!", 3, 1
        )

        throw PostNotFoundException("post was not found")

    }
}

