package uz.turgunboyevjurabek.navigationdrawer

import android.icu.text.CaseMap.Title
import androidx.compose.ui.graphics.vector.ImageVector
import java.lang.invoke.TypeDescriptor

data class MenuItem(
    val id :String,
    val title: String,
    val contentDescriptor: String,
    val icon:ImageVector
)
