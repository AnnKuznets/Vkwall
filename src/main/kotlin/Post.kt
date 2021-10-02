import java.lang.RuntimeException
import kotlin.reflect.typeOf

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
    var attachments: Array<WallService.Attachment>
)
data class Comment(
    val postId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val replyToUser: Int,
    val replyToComment: Int,
)
class PostNotFoundException(message: String) : RuntimeException(message)

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == comment.postId) {
                val newComment = comment.copy(
                    postId = if (comments.isNotEmpty()) comments.last().postId + 1 else 0
                )
                comments += newComment
            } else {
                throw PostNotFoundException("post was not found")
            }
        }
    }


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
    }

    class Audio(id: Int = 1, albumId: Int = 1, ownerId: Int = 1, userId: Int = 1)
    class Video(id: Int = 1, albumId: Int = 1, ownerId: Int = 1, userId: Int = 1)


    class AudioAttachment(override val type: String = "audio", val audio: Audio = Audio()) : Attachment
    class VideoAttachment(override val type: String = "video", val video: Video = Video()) : Attachment

    var attachments: Array<Attachment> = arrayOf(AudioAttachment(), VideoAttachment())

    fun main(attachment: Attachment) : Attachment {
        if (attachment is AudioAttachment)
            print(Audio())
        if (attachment is VideoAttachment)
            print(Video())
        TODO()
    }
}