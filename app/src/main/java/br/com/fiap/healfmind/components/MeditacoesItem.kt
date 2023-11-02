package br.com.fiap.healfmind.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.healfmind.R
import br.com.fiap.healfmind.model.Meditacao
import coil.compose.AsyncImage

//import coil.compose.AsyncImage


@Composable
fun MeditacoesItem(meditacao: Meditacao) {


            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                Box(){
//                    Image(painter = painterResource(id = meditacao.url), contentDescription = null )
                    AsyncImage(
                        model = meditacao.url,
                        contentDescription = null,
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth())
                }
                        //placeholder = painterResource(id = R.drawable.ic_launcher_background)

                }

            }








@Preview(showBackground =  true)
@Composable
fun MeditacoesItemPreview(){

    MeditacoesItem( Meditacao(
        titulo = "Teste",
        url = "http://pt.hdwall365.com/wallpapers/1512/Winter-sunrise-lake-ice-snow-beautiful-scenery_1280x1024_wallpaper.jpg"
    ) )
}