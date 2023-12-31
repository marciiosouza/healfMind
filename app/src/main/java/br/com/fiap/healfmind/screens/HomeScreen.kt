@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.fiap.healfmind.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.Footer
import com.example.healf_mind.components.CardHome


//data class BottonNavigationItem(
//    val title: String,
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    val hasNew: Boolean,
//    val badgeCount: Int? = null // Contador de notificações
//)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(nome: String , navController: NavController) {
    var pesquisa by remember {
        mutableStateOf("")
    }

//    val items = listOf(
//        BottonNavigationItem(
//            title = "Home/{nome}",
//            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Filled.Home,
//            hasNew = false,
//
//            ),
//        BottonNavigationItem(
//            title = "Perfil",
//            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Filled.Person,
//            hasNew = false,
//
//            ),
//        BottonNavigationItem(
//            title = "Meditacoes",
//            selectedIcon = Icons.Filled.PlayArrow,
//            unselectedIcon = Icons.Filled.PlayArrow,
//            hasNew = false,
//
//            )
//
//    )

    Column(modifier = Modifier
        .fillMaxWidth(),

       // .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,


    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    navController.navigate("Menu")
                }
            ) {
            Icon(painter = painterResource(id = R.drawable.menu_menu) ,contentDescription = "Menu",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),

            )}

            Text(
                text = "Home",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF005DF9),

                ),
            )
            IconButton(
                onClick = {
                    navController.navigate("Perfil") }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.perfil) ,contentDescription = "Perfil",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    contentScale = ContentScale.FillBounds,
                    )
            }
        }
        Column(
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 20.dp
                )
                .align(alignment = Alignment.Start)
        ){
            Text(
                text = "Olá $nome",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "Encontre o médico adequado para você",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF969696),
                )
            )
        }
        Column(
            //modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = pesquisa,
                onValueChange = {
                        letra -> pesquisa = letra
                },
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .padding(bottom = 20.dp)
                    .width(370.dp)
                    .height(50.dp)
                    .background(color = Color(0xFFFAFAFA), shape = RoundedCornerShape(size = 50.dp)),
                shape = RoundedCornerShape(30.dp),
                placeholder = {
                    Text(text = "Pesquisar", color = colorResource(id = R.color.cinza))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search), contentDescription = "",
                        Modifier.size(15.dp)
                        )
                }
            )
            Card (modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(370.dp)
                .height(107.dp),
                colors = CardDefaults.cardColors(Color(0xFF005DF9)),
                shape = RoundedCornerShape(25.dp),


                ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "Uma nova opção para você cuidar da sua saúde",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )

                    )
                }

            }
            Row (
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 15.dp, top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                modifier = Modifier
                    .width(7.dp)
                    .height(24.dp) ,
                    colors = CardDefaults.cardColors(Color(0xFF005DF9)),


            ) {

            }
            Text(
                text = "Consultas",
                modifier = Modifier.padding(start = 10.dp),
                    //.padding(start = 20.dp, top = 20.dp, bottom = 15.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )

            )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp, bottom = 15.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardHome(titulo = "Marcar\nconsulta" , caminhoImagem = R.drawable.doutor2 , navController , "MarcarConsulta")
                CardHome(titulo = "Minhas\nconsultas" , caminhoImagem = R.drawable.consulta2,navController , "")
                CardHome(titulo = "Clínicas" , caminhoImagem = R.drawable.clinica2,navController , "")
            }
            Text(
                text = "Parceiros com desconto",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 20.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Row (
                modifier = Modifier
                    .padding(15.dp)
                    .align(alignment = Alignment.Start),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(7.dp)
                        .height(24.dp) ,
                    colors = CardDefaults.cardColors(Color(0xFF00F0AD)),

                        ){}

                Text(
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Confira todos os estabelecimentos\nparceiros com desconto e aproveite",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 15.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF969696),
                    )
                )
            }
            Footer(navController , "Meditacoes" )
            //BottonNavigation(navController)

        }
    }
}



//@Preview(showSystemUi =  true , showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen("Wagner " ,  )
//}

