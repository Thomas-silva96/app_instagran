package co.tsdroiddeveloper.course.instagram.register.data

interface RegisterDataSource {
    fun create(email: String, callback: RegisterCallback)
    fun create(email: String, name: String, password: String, callback: RegisterCallback)
}
