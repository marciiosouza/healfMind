package br.com.fiap.healfmind.screens

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.healfmind.components.Footer
import br.com.fiap.healfmind.components.MeditacoesItem
import br.com.fiap.healfmind.data.dataMeditacao
import br.com.fiap.healfmind.model.Meditacao

@Composable
fun MeditacoesScreen( meditacoes: List<Meditacao>) {

    LazyRow (){
        items(meditacoes) {
            p -> MeditacoesItem(meditacao = p)

        }
    }
    //Footer(nav)
}



@Preview(showSystemUi =  true)
@Composable
fun MeditacoesScreenPreview(){

    MeditacoesScreen(meditacoes = dataMeditacao)
}