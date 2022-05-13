package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.add.data.FireAddDataSource
import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.RuntimeException

class FireHomeDataSource : HomeDataSource {
    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        val uid = FirebaseAuth.getInstance().uid ?: throw RuntimeException("Usuário não encontrado")
        FirebaseFirestore.getInstance()
            .collection("/feeds")
            .document(uid)
            .collection("posts")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { res ->
                val feed = mutableListOf<Post>()
                val documents = res.documents
                for (document in documents) {
                    val post = document.toObject(Post::class.java)
                    post?.let { feed.add(it) }
                }
                callback.onSuccess(feed)
            }
            .addOnFailureListener { exception ->
                callback.onFailure(exception.message ?: "Erro ao carregar o feed")
            }
            .addOnCompleteListener {
                callback.onComplete()
            }
    }

    override fun logout() {
        FirebaseAuth.getInstance().signOut()
    }
}