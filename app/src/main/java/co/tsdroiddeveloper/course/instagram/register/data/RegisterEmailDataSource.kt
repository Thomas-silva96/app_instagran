package co.tsdroiddeveloper.course.instagram.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback)
}