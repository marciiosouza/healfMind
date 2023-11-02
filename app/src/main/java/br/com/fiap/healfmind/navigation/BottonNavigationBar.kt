package br.com.fiap.healfmind.navigation


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottonNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottonNavItem.Home,
        BottonNavItem.Meditacao
    )

    NavigationBar(contentColor = Color.Yellow ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route){
                        // garatir que a tela sera colocada no inicio da pilha de navegação.
                        // remover todas as intancias da mesma tela na pilha
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = destination.icon, contentDescription = null )
                },
                label = {
                    Text(text = destination.titulo)
                }
            )
        }
    }


}


@Preview(showSystemUi =  true , showBackground = true)
@Composable
fun BottonNavigationBarPreview() {
    BottonNavigationBar( navController = rememberNavController() )
}