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
    val postponedId: Int,
    val reposts: Post?,
    val attachments: String
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
        for ((index, prePost) in posts.withIndex()) {
            if (prePost.id == post.id) {
                val updatedPost = post.copy(ownerId = prePost.ownerId, date = prePost.date)
                posts[index] = updatedPost
                return true
            }
        }
        return false
    }

    fun repost(post: Post): Post {
        val reposts = post.reposts ?: post
        TODO()
    }

    interface Attachment {
        val type: String
        val attachment: Any


        var attachments: Array<Attachment>
    }

    open class AudioAttachment(override val type: String, override var attachments: Array<Attachment>,
                               override val attachment: Any
    ) : Attachment {

        fun main(){
            if (attachment !is AudioAttachment){
                TODO()
            }
            val type = (attachment as AudioAttachment)
        }

    }
    class Audio(val id: Int, val albumId : Int, type: String, attachments: Array<Attachment>, attachment: Any) : AudioAttachment(type,
        attachments, attachment
    )
}
