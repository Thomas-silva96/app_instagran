package co.tsdroiddeveloper.course.instagram.register.data

class RegisterEmailRepository(private val emailDataSource: RegisterEmailDataSource) {

    fun create(email: String, Callback: RegisterEmailCallback) {
        emailDataSource.create(email, Callback)
    }
}