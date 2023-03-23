package project.android.rauljcs5.ui.screen.lobby

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import project.android.rauljcs5.LocalPlayerDto
import project.android.rauljcs5.ui.screen.main.MainActivity

class LobbyActivity: ComponentActivity(){

    companion object {
        private const val PLAYER_EXTRA = "PLAYER_EXTRA"
        fun navigate(context: Activity, player: LocalPlayerDto? = null) {
            with(context) {
                val intent = Intent(this, LobbyActivity::class.java)
                if (player != null)
                    intent.putExtra(PLAYER_EXTRA, player)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked sign in")
        finish()
    }

}