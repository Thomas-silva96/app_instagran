package co.tsdroiddeveloper.course.instagram.common.model

import android.net.Uri
import java.util.*

data class Post(
    val uuid: String,
    val uri: Uri,
    val caption: String,
    val timestamp: Long
)
