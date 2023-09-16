package br.com.fiap.healfmind.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.ui.theme.Inter


@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun MenuScreen (navController:NavController) {
    Column(modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth())
    {

        Text(
            text = "Dados Pessoais",
            fontSize = 16.sp,
            // fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = Color(0xFF000000),

            )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "" ,
            onValueChange = {},
            placeholder = {
                Text(text = " Nome Completo: ",
                    color = Color(0xFFAFAFAF)
                )
            })

        Spacer(modifier = Modifier.height(12.dp))


        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "" ,
            onValueChange = {},

            placeholder = {
                Text(text = "CPF: ",
                    color = Color(0xFFAFAFAF)
                )
            }


        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Dados de contato",
            fontSize = 16.sp,
            // fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = Color(0xFF000000),

            )

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "" ,
            onValueChange = {},
            placeholder = {
                Text(text = " Celular: ",
                    color = Color(0xFFAFAFAF)
                )
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.edit_info), contentDescription = "icone editar",
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp))
            })

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "" ,
            onValueChange = {},

            placeholder = {
                Text(text = "E-mail: ",
                    color = Color(0xFFAFAFAF)
                )
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.edit_info), contentDescription = "icone editar",
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp))
            }
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "" ,
            onValueChange = {},

            placeholder = {
                Text(text = "Endereço: ",
                    color = Color(0xFFAFAFAF)
                )

            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.edit_info), contentDescription = "icone editar",
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp))
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Segurança",
            fontFamily = Inter,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,

            color = Color(0xFF000000),

            )

        Spacer(modifier = Modifier.height(12.dp))


        Row() {

            Column {
                Text(
                    text = "Alterar a senha do app",

                    fontSize = 16.sp,
                    // fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFAFAFAF),
                )
            }

            Column {

            }




        }



    }



}



@Preview(showSystemUi =  true , showBackground = true)
@Composable
fun PerfilScreenPreview() {
    PerfilScreen()
}
