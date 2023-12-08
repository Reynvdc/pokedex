package be.reynvdc.pokedex.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title:String = "",
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    color: Color = Color.Transparent,
    modifier: Modifier = Modifier,
    actionIcons: @Composable RowScope.() -> Unit? = {}
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = color)){
        Row (
            modifier = Modifier
                .weight(.3f)
                .padding(start = 8.dp),
            horizontalArrangement = Arrangement.Start
            ){
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp,
                    modifier= Modifier.fillMaxWidth()
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button),
                            tint = Color.White
                        )
                        Text(
                            text = stringResource(id = R.string.back_button),
                            color = Color.White)
                    }
                }
            }

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(0.4f)
        ){
            Text(text = title,fontSize = MaterialTheme.typography.titleLarge.fontSize, color = Color.White)
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(0.3f)
                .padding(end = 8.dp)
        ) {
            actionIcons()
        }
    }
}

@Composable
fun FavoriteIcon(isFavorite: Boolean = false, onClickFavorite: () -> Unit = {}) {
    val icon = if(isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    IconButton(
        onClick = onClickFavorite
    ) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(R.string.favorite_button),
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun AppBarPreview(modifier: Modifier = Modifier){
    PokedexTheme {
        Surface(color = Color.Blue) {
                AppBar(title = "Title", canNavigateBack = true){
                    FavoriteIcon()
                }
        }
    }
}
