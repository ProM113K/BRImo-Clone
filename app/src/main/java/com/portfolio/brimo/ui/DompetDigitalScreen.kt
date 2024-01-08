package com.portfolio.brimo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.brimo.R
import com.portfolio.brimo.data.IconButton
import com.portfolio.brimo.data.IconButtonData
import com.portfolio.brimo.ui.theme.BRImoTheme

@Composable
fun DompetDigitalScreen(
    dataTopUpButton: List<IconButton>,
    modifier: Modifier = Modifier,
    onClickNav: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        TopUpCard(dataTopUpButton = dataTopUpButton, onClickNav = onClickNav)
        Spacer(modifier = Modifier.height(8.dp))
        DaftarDompetCard()
        Button(
            onClick = { },
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button)),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Top Up Baru",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }
    }
}

@Composable
fun TopUpCard(dataTopUpButton: List<IconButton>, onClickNav: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(
            topStartPercent = 0,
            topEndPercent = 0,
            bottomEndPercent = 2,
            bottomStartPercent = 2
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Top Up Terakhir",
                style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.navy)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TopUpButtonList(data = dataTopUpButton, onClickNav = onClickNav)
        }
    }
}

@Composable
fun DaftarDompetCard() {
    var daftarDompetText by rememberSaveable { mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.83f)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Daftar Dompet Digital", style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.navy)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = daftarDompetText,
                onValueChange = { daftarDompetText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(
                        text = "Cari Daftar",
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.colors(unfocusedContainerColor = colorResource(id = R.color.light_blue)),
                shape = ShapeDefaults.Small
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Belum Ada Daftar", color = Color.Gray)
            }
        }
    }
}

@Composable
fun TopUpButtonList(data: List<IconButton>, onClickNav: () -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(space = 24.dp),
        contentPadding = PaddingValues(horizontal = 18.dp)
    ) {
        items(items = data) { data ->
            IconButtonItem(
                image = data.logo,
                title = data.title,
                subTitle = data.subTitle,
                modifier = Modifier.wrapContentWidth(),
                onClick = { onClickNav() },
                navRoute = data.navRoute
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DDSPreview() {
    BRImoTheme {
        Surface {
            DompetDigitalScreen(
                dataTopUpButton = IconButtonData.setTopUpIconButton,
                onClickNav = {})
        }
    }
}