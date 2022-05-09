package co.tsdroiddeveloper.course.instagram.add.data

import co.tsdroiddeveloper.course.instagram.common.model.DataBase
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth
import java.lang.RuntimeException

class AddLocalDataSource : AddDataSource {

    override fun fetchSession(): UserAuth {
        return DataBase.sessionAuth ?: throw RuntimeException("Usuário não logado!!")
    }
}