package br.com.fiap.healfmind.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.components.MeditacoesItem
import br.com.fiap.healfmind.data.dataMeditacao
import br.com.fiap.healfmind.model.Meditacao
import com.example.healf_mind.components.CaixaDeEntrada

@Composable
fun MeditacoesScreen( meditacoes: List<Meditacao>) {
        Column {

            CaixaDeEntrada(
                label = "Pesquisar",
                placeholder = "Pesquisr" ,
                value = "Pesquisar",
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .width(330.dp),
                atualizarValor = {},
                error = false
            )
            Text(
                text = "Aprenda a meditar",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            LazyRow (
                Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 15.dp)
            ){
            items(meditacoes) {
                    p -> MeditacoesItem(meditacao = p)

            }
        }
            Text(
                text = "Meditações",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            LazyColumn(){
                for(meditacao in meditacoes){
                    item{
                        MeditacoesItem(meditacao = meditacao)
                    }

                }
            }
        }




    //Footer(nav)
}



@Preview(showSystemUi =  true)
@Composable
fun MeditacoesScreenPreview(){

    MeditacoesScreen(meditacoes = dataMeditacao)
}