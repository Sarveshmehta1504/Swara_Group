package com.example.swaragroup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swaragroup.R
import com.example.swaragroup.components.NormalHeadingText
import com.example.swaragroup.components.OTPTextFields
import com.github.ehsannarmani.otp.ui.Otp

@Composable
fun OTPScreen(
    navController: NavController
) {
    var otpVal: String? = null
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValue ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
            ) {
                IconButton(
                    modifier = Modifier,
                    onClick = {
                        navController.popBackStack()
                    }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Arrow",
                        modifier = Modifier
                            .size(30.dp)
                            .defaultMinSize(30.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                NormalHeadingText(value = "Verification", textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Enter 6 digit OTP",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 22.sp,
                        fontFamily = androidx.compose.ui.text.font.FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(600),
                        color = Color("#BEBEBE".toColorInt()),
                        textAlign = TextAlign.Start
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                val successColor = Color(0xff17917a)
                val errorColor = Color(0xFFFF6969)

                var error by remember {
                    mutableStateOf(false)
                }
                var success by remember {
                    mutableStateOf(false)
                }
                Otp(
                    count = 6,
                    error = error,
                    success = success,
                    errorColor = errorColor,
                    successColor = successColor,
                    focusedColor = Color(0xff313131),
                    unFocusedColor = Color.Gray,
                    onFinish = { otp ->
                        if (otp == "123456") {
                            success = true
                            error = false
                        } else {
                            success = false
                            error = true
                        }
                    },
                    modifier = Modifier
                        .size(53.dp, 57.dp)
                        .align(Alignment.CenterHorizontally),
                )
                Spacer(modifier = Modifier.height(30.dp))
                androidx.compose.material3.Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(47.dp)
                        .widthIn(313.dp),
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(47.dp)
                            .background(
                                color = colorResource(id = R.color.purple_main)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.defaultMinSize(88.dp,28.dp),
                            text = "Submit",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontWeight = FontWeight(700),
                                color = Color("#FFFFFF".toColorInt()),
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OTPScreenPreview() {
    OTPScreen(navController = rememberNavController())
}