package project.android.rauljcs5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SignedInActivity : ComponentActivity() {

    private val repo by lazy {
        (application as DependenciesContainer).userRepo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

        }
    }

}
