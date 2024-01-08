package com.portfolio.brimo.ui

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.brimo.R
import com.portfolio.brimo.data.IconButton
import com.portfolio.brimo.data.IconButtonData
import com.portfolio.brimo.ui.theme.BRImoTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    dataIconButton: List<IconButton>,
    onClickNav: (String) -> Unit,
) {

    var showFastMenuSheet by remember { mutableStateOf(false) }
    var loginSheet by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {
            FastMenu(
                onClickBottomState = { showFastMenuSheet = true },
                dataIconButton = dataIconButton,
                onClickNav = onClickNav
            )
            ButtonLogin(onClickBottomSheet = { loginSheet = true })
            if (showFastMenuSheet) {
                FastMenuSheets(onDismiss = { showFastMenuSheet = false })
            } else if (loginSheet) {
                LoginSheets(onDismiss = { loginSheet = false })
            }
        }
    }
}

@Composable
fun IconButtonList(
    dataIconButton: List<IconButton>,
    onClick: (String) -> Unit
) {
    LazyRow {
        items(dataIconButton) { icon ->
            IconButtonItem(
                image = icon.logo,
                title = icon.title,
                subTitle = icon.subTitle,
                modifier = Modifier
                    .width(78.dp)
                    .padding(horizontal = 8.dp),
                onClick = { onClick(it) },
                navRoute = icon.navRoute
            )
        }
    }
}

@Composable
fun FastMenu(
    onClickBottomState: () -> Unit,
    dataIconButton: List<IconButton>,
    onClickNav: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentSize()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Fast Menu",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
            IconButton(onClick = onClickBottomState) {
                Image(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        IconButtonList(dataIconButton = dataIconButton, onClickNav)
    }
}

@Composable
fun ButtonLogin(onClickBottomSheet: () -> Unit) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .paddingFromBaseline(top = 128.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Button(
                onClick = { onClickBottomSheet() },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(0.23f),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button))
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            FilledIconButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .fillMaxHeight(0.23f)
                    .fillMaxWidth(0.13f),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(id = R.color.blue_button))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fingerprint),
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FastMenuSheets(onDismiss: () -> Unit) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        dragHandle = { BottomSheetDefaults.DragHandle() }) {
        Column(modifier = Modifier.padding(horizontal = 14.dp)) {
            Text(
                text = "Tentang Fast Menu",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
            Text(
                text = "Apa itu Fast Menu?", fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = stringResource(id = R.string.fast_menu_desc),
                modifier = Modifier.padding(bottom = 24.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = "Cara mengatur Fast Menu",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = stringResource(id = R.string.fast_menu_setting_tutor),
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.17f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSheets(onDismiss: () -> Unit) {
    var usernameText by rememberSaveable {
        mutableStateOf("")
    }
    var passwordText by rememberSaveable {
        mutableStateOf("")
    }

    ModalBottomSheet(onDismissRequest = { onDismiss() }) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize
            )
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = usernameText,
                onValueChange = { usernameText = it },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = null)
                },
                placeholder = {
                    Text(text = "Username")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(18.dp))
            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = null)
                },
                placeholder = {
                    Text(text = "Password")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(24.dp))
            FilledTonalButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(12),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.08f),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button))
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.03f))
            Text(
                text = "Lupa Username/Password?",
                textDecoration = TextDecoration.Underline,
                color = colorResource(
                    id = R.color.blue_button
                ),
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.15f))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LSPreview() {
    BRImoTheme {
        Surface {
            LoginScreen(
                dataIconButton = IconButtonData.setLoginIconButton,
                onClickNav = {},
            )
        }
    }
}