data class Post (
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int
)
class WallService {
    private var posts = emptyArray<Post>()


    fun add(post: Post): Post {
        val newPost = post.copy(
            id = if (posts.isNotEmpty()) posts.last().id + 1 else 0
        )
        posts += newPost
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for ((id) in posts.withIndex()) {
            if (post.id == id) {
                posts[id] = post.copy(ownerId = post.ownerId, date = post.date)
                return true
            }
        }
        return false
    }
}
