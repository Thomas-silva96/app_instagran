package co.tsdroiddeveloper.course.instagram.common.model

import java.util.*

object DataBase {

    val usersAuth = mutableListOf<UserAuth>()
    val posts = hashMapOf<String, MutableSet<Post>>()
    val feeds = hashMapOf<String, MutableSet<Post>>()
    val followers = hashMapOf<String, MutableSet<String>>()

    var sessionAuth: UserAuth? = null

    init {

        val userA = UserAuth(
            UUID.randomUUID().toString(),
            "UserA",
            "userA@gmail.com",
            "12345678",
            null
        )

        usersAuth.add(userA)

        //sessionAuth = usersAuth.first()
    }

}