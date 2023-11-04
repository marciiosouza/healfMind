package br.com.fiap.healfmind

import LoginScreen
import LoginScreenViewModel
import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.healfmind.data.dataMeditacao
import br.com.fiap.healfmind.screens.CadastroScreen
import br.com.fiap.healfmind.screens.HomeScreen
import br.com.fiap.healfmind.screens.MarcarConsultaScreen
import br.com.fiap.healfmind.screens.MeditacoesScreen
import br.com.fiap.healfmind.screens.PerfilScreen
import br.com.fiap.healfmind.ui.theme.HealfMindTheme
import br.com.fiap.healfmind.viewModel.CadastroScreenViewModel
import br.com.fiap.healfmind.viewModel.MarcarConsultaScreenViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import androidx.compose.material3.Surface as Surface


//data class BottonNavigationItem(
//    val title: String,
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    val hasNew: Boolean,
//    val badgeCount: Int? = null // Contador de notificações
//)
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealfMindTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background,


                    ) {
                    val navController = rememberAnimatedNavController()

                    // animaçãona transição da tela

                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "Login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                tween(800)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(towards = AnimatedContentScope.SlideDirection.Down,
                                tween(1000)
                            )
                        }
                    ){
                        composable(route = "Login"){
                            // Passando a instancia de LoginScreenViewModel usando a chave para usar o construtor da classe
                            // Nav controle instancia de navegação entre telas
                            LoginScreen( LoginScreenViewModel() ,navController)
                        }
                        composable(route = "Home/{nome}"){
                            var nome = it.arguments?.getString("nome")
                            HomeScreen(nome!!, navController ) // double bang -> Tratar valoresNull
                            //HomeScreen( ) // double bang -> Tratar valoresNull
                        }

                        composable(route = "Perfil"){
                            PerfilScreen( navController )
                        }
                        composable(route = "Cadastro"){
                            CadastroScreen( navController , CadastroScreenViewModel() )
                        }
                        composable(route = "MarcarConsulta"){
                            MarcarConsultaScreen(MarcarConsultaScreenViewModel()  )
                        }
                        composable(route = "Meditacoes"){
                            MeditacoesScreen(meditacoes = dataMeditacao)
                        }

                    }

                }

            }
        }
    }
}

@Preview(showSystemUi =  true , showBackground = true)
@Composable
fun MainActivityPreview() {
    MainActivity()
}