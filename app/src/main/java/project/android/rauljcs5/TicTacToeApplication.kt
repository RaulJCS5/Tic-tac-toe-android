package project.android.rauljcs5

import android.app.Application

interface DependenciesContainer {
    val userRepo: UserRepository
}

class TicTacToeApplication : DependenciesContainer, Application() {
    override val userRepo: UserRepository
        get() = UserRepositoryShared(this)
}