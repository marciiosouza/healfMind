package br.com.fiap.healfmind.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottonNavItem(val titulo:String, val icon: ImageVector, val route:String){
    object Home : BottonNavItem(
        titulo = "Home",
        icon = Icons.Default.Home,
        route = "Home/{nome}"
    )

    object Meditacao : BottonNavItem(
        titulo = "Meditacoes",
        icon = Icons.Default.PlayArrow,
        route = "Meditacoes"
    )
}
