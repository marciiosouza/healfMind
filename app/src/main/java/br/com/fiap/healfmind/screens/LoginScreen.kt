import androidx.compose.foundation.Image
<<<<<<< HEAD
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
=======
>>>>>>> 2cf1f3c24607f2baf7c326b90ac0aebe7e7efe58
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
<<<<<<< HEAD
import androidx.compose.material3.TextField
=======
import androidx.compose.material3.TextButton
>>>>>>> 2cf1f3c24607f2baf7c326b90ac0aebe7e7efe58
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.ui.theme.ColorBlue
import br.com.fiap.healfmind.ui.theme.ColorBlueGradient
import br.com.fiap.healfmind.ui.theme.ColorPrimary
import br.com.fiap.healfmind.ui.theme.ColorWhite
import com.example.healf_mind.components.CaixaDeEntrada


@Composable
fun LoginScreen(
    loginScreenViewModel: LoginScreenViewModel,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var erroEmail by remember { mutableStateOf(false) }
    var erroSenha by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFAFAFA)
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        CaixaDeEntrada(
            label = "E-mail",
            placeholder = "Digite seu e-mail aqui",
            value = email,
            keyboardType = KeyboardType.Email,
            modifier = Modifier
<<<<<<< HEAD
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .width(270.dp),
            atualizarValor = { email = it },
            erroEmail
        )

        if (erroEmail) {
            Text(
                text = "E-mail inválido",
                fontSize = 14.sp,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                textAlign = TextAlign.End
            )
=======
                .height(400.dp)
                .width(360.dp)
                .fillMaxWidth()
                .padding(20.dp),
            colors = CardDefaults.cardColors(Color(0xFFFAFAFA)),
            shape = RoundedCornerShape(35.dp),
            elevation = CardDefaults.cardElevation(4.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 40.dp),


                horizontalAlignment = Alignment.CenterHorizontally

//
            ){
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.inter_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF005DF9)
                ))
                CaixaDeEntrada(
                    label = "Insira seu e-mail",
                    placeholder = "Digite seu e-mail aqui",
                    value = texto,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x1A000000),
                            ambientColor = Color(0x1A000000)
                        )
                        .width(270.dp)
                        //.height(50.dp)
                    //.background(
                    // color = Color(0xFFFAFAFA),
                    //shape = RoundedCornerShape(size = 30.dp)
                    //)
                    //.padding(top = 20.dp,bottom = 50.dp)
                    ,
                    atualizarValor = {
                        loginScreenViewModel.onTextoChanged(it)
                    },
                    erroEmail

                )
                if(erroEmail){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        textAlign = TextAlign.End,
                        text = "O e-mail é obrigatório!",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))

                CaixaDeEntrada(
                    label = "Insira sua senha",
                    placeholder = "Insira sua senha",
                    value = senha,
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x1A000000),
                            ambientColor = Color(0x1A000000)
                        )
                        .width(270.dp),
                        //.height(50.dp),
                    //.background(
                    // color = Color(0xFFFAFAFA),
                    //shape = RoundedCornerShape(size = 30.dp)
                    // ),
                    atualizarValor = {
                        if(it.length <= tamanhoMax)
                            loginScreenViewModel.onPasswordChanged(it)
                    },
                    false
                )

                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        if(texto.isEmpty()){
                            erroEmail = true
                        } else{
                            erroEmail = false
                            navController.navigate("Home/Wagner")
                        }
                    },
                    modifier = Modifier
                        .size(width = 230.dp, height = 50.dp)
                        .padding(bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005DF9))

                ) {
                    Text(
                        text = "Entrar",

                        )

                }


                TextButton(
                    onClick = {
                        navController.navigate("Cadastro")
                    }
                ) {
                    Text(
                        text = "Criar conta com e-mail",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF005DF9),
                        )
                    )
                }



                    //modifier = Modifier.padding(top = 30.dp)


            }
>>>>>>> 2cf1f3c24607f2baf7c326b90ac0aebe7e7efe58
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Use o TextField com visualTransformation para ocultar a senha
        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .width(270.dp)
        )

        if (erroSenha) {
            Text(
                text = "Senha inválida",
                fontSize = 14.sp,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                textAlign = TextAlign.End
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                erroEmail = !isValidEmail(email)
                erroSenha = senha.length < 6 // Validar a senha como desejar

                if (!erroEmail && !erroSenha) {
                    // Lógica para processar o login
                    navController.navigate("Home/Wagner")
                }
            },
            modifier = Modifier
                .width(230.dp)
                .height(50.dp)
                .padding(bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005DF9))
        ) {
            Text(text = "Entrar")
        }

        Text(
            text = "Criar conta com e-mail",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF005DF9)
            )
        )
    }
}

private fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}





