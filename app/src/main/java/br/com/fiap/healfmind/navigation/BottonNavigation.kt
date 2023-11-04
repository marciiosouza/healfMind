package br.com.fiap.healfmind.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healfmind.data.dataMeditacao
import br.com.fiap.healfmind.screens.HomeScreen
import br.com.fiap.healfmind.screens.MeditacoesScreen
import br.com.fiap.healfmind.screens.PerfilScreen


data class BottonNavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
   // val hasNew: Boolean,
  //  val badgeCount: Int? = null // Contador de notificações
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottonNavigation(navController: NavController, function: () -> Unit) {

    val navController : NavHostController = rememberNavController()
//    var selectedItemIndex by rememberSaveable {
//        mutableStateOf(0)
//    }

    val listOfNavItems = listOf(
        BottonNavigationItem(
            label = "Home",
            icon = Icons.Filled.Home,
            route = Screens.HomeScreen.name
             ),
        BottonNavigationItem(
            label = "Perfil",
            icon = Icons.Filled.Person,
            route = Screens.PerfilScreen.name,
            ),
        BottonNavigationItem(
            label = "Meditacoes",
            icon = Icons.Filled.PlayArrow,
            route = Screens.MeditacoesScreen.name,
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem -> 
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any{it.route == navItem.route} == true,
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null
                               )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController ,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.HomeScreen.name) {
                HomeScreen(nome = "Wagner", navController = navController)
            }
            composable(route = Screens.PerfilScreen.name) {
                PerfilScreen(navController = navController)
            }
            composable(route = Screens.MeditacoesScreen.name) {
                MeditacoesScreen(dataMeditacao)
            }
        }
    }
}