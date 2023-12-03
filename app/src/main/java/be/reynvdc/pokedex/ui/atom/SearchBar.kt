package be.reynvdc.pokedex.ui.atom

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(inputValue: String = "", onSearchAction: (String) -> Unit = {}, modifier : Modifier = Modifier) {
    TextField(
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search")},
        value = inputValue,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = onSearchAction,
        modifier = modifier
            .graphicsLayer(shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = "Pokemon zoeken", )}
    )
}


@Preview
@Composable
fun SearchBarPreview() {
    PokedexTheme {
        SearchBar()
    }
}