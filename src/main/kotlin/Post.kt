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
            id = 1
        )
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (post in posts) {
            if (post.id == 2) {
                posts[2] = post.copy(id = 2)
                return true
            }
        }
         return false
    }
}