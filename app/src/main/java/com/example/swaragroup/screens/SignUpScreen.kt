package com.example.swaragroup.screens

import android.net.Uri
import androidx.compose.material3.TextField
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.swaragroup.R
import com.example.swaragroup.components.NormalHeadingText
import com.example.swaragroup.navigation.Screen
import com.example.swaragroup.rememberImeState
import com.example.swaragroup.ui.theme.PurpleMain


@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavController
) {
    val imageUri = rememberSaveable {
        mutableStateOf("")
    }
    val painter = rememberAsyncImagePainter(
        imageUri.value.ifEmpty {
            R.drawable.ic_user_profile_pic_signup
        }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(scrollState)
        ) {
            IconButton(
                modifier = Modifier.defaultMinSize(30.dp),
                onClick = {
                    navController.navigateUp()
                }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            NormalHeadingText(value = "Sign Up", TextAlign.Start)
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Create an account for updates \nand connectivity",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(23.dp),
                style = TextStyle(
                    fontSize = 19.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                    textAlign = TextAlign.Start,
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                shape = CircleShape,
                colors = CardDefaults.cardColors(
                    colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.Start)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.size(116.dp,122.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "Profile Pic",
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                            .clickable {
                                launcher.launch("image/*")
                            },
                        contentScale = ContentScale.Crop
                    )
                }
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.Start),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.solar_camera_icon),
                        contentDescription = "camera",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(20.dp, 6.dp)
                            .background(Color.Black)
                            .padding(10.dp)
                            .clickable {
                                launcher.launch("image/*")
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            }
            var phoneNumber by rememberSaveable {
                mutableStateOf("")
            }
            var name by rememberSaveable {
                mutableStateOf("")
            }
            var email by rememberSaveable {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Phone Number",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.open_sans)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFBEBEBE),

                            )
                    )
                    TextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        maxLines = 1,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontSize = 18.sp,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        )
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Column {
                    Text(
                        text = "Full Name",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.open_sans)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFBEBEBE),

                            )
                    )
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        maxLines = 1,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontSize = 18.sp,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        )
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Column {
                    Text(
                        text = "Email",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.open_sans)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFBEBEBE),

                            )
                    )
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        maxLines = 1,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontSize = 18.sp,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Done
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        )
                    )
                }


            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, bottom = 30.dp)
                .defaultMinSize(360.dp, 47.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(PurpleMain),
                onClick = {
                    navController.navigate(Screen.Login.route)
                },
            ) {
                Text(
                    text = "Continue",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        }

    }
}
