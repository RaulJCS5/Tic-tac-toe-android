package project.android.rauljcs5.ui.screen.game.model

enum class Marker {
    CIRCLE, CROSS;
    companion object {
        val firstToMove: Marker = CIRCLE
    }
    val other: Marker
        get() = if (this == CIRCLE) CROSS else CIRCLE
}