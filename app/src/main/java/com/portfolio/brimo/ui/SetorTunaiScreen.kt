package com.portfolio.brimo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.brimo.R
import com.portfolio.brimo.ui.theme.BRImoTheme

@Composable
fun SetorTunaiScreen() {

    var rekeningSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        RekeningTujuanCard(onClick = { rekeningSheet = !rekeningSheet })
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button))
            ) {
                Text(
                    text = "Lanjutkan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
        if (rekeningSheet) {
            RekeningTujuanSheet(onDismiss = { rekeningSheet = false })
        }
    }
}

@Composable
fun RekeningTujuanCard(onClick: () -> Unit) {
    Card(
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "Rekening Tujuan", style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.navy)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                AssistChip(
                    onClick = { onClick() },
                    label = {
                        Text(
                            text = "7367 0101 3348 531",
                            modifier = Modifier.weight(1f),
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.rekening_icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    border = AssistChipDefaults.assistChipBorder(borderColor = Color.LightGray)
                )
                Text(
                    text = "Informasi Limit",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(top = 12.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.navy)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RekeningTujuanSheet(onDismiss: () -> Unit) {
    ModalBottomSheet(onDismissRequest = { onDismiss() }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rekening_image),
                contentDescription = null
            )
            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = colorResource(id = R.color.gold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "7367 9009 8878 887", fontWeight = FontWeight.Bold)
                }
                Text(text = "DIMAS PUTRA WIDIYANTO", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Normal)
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.20f))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun STPreview() {
    BRImoTheme {
        Surface {
            SetorTunaiScreen()
        }
    }
}