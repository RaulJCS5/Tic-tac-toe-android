package project.android.rauljcs5

import android.app.Application
import project.android.rauljcs5.user.UserRepository
import project.android.rauljcs5.user.UserRepositoryShared

interface DependenciesContainer {
    val userRepo: UserRepository
}

class TicTacToeApplication : DependenciesContainer, Application() {
    override val userRepo: UserRepository
        get() = UserRepositoryShared(this)
}