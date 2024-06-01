package com.example.swaragroup.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swaragroup.R
import com.example.swaragroup.components.DividerTextComponent
import com.example.swaragroup.components.GoogleButton
import com.example.swaragroup.components.MyTextField
import com.example.swaragroup.components.NormalButtonComponent
import com.example.swaragroup.components.NormalHeadingText
import com.example.swaragroup.components.NormalSubHeadingText
import com.example.swaragroup.navigation.Screen
import com.example.swaragroup.ui.theme.Primary
import com.example.swaragroup.ui.theme.PurpleMain

@Composable
fun LoginScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(38.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            Spacer(modifier = Modifier.heightIn(75.dp))
            NormalHeadingText(value = "Sign In", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(15.dp))
            NormalSubHeadingText(value = "Login with your Phone Number")
            Spacer(modifier = Modifier.height(25.dp))
            MyTextField(
                labelValue = "Enter your phone number",
                painterResource = painterResource(R.drawable.phone_icon_1)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {
                          navController.navigate(Screen.OTPScreen.route)
                },
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
                        text = "Continue",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            DividerTextComponent(value = "Or")
            GoogleButton(value = "Continue with Google")
            Spacer(modifier = Modifier.height(11.dp))
            val initText = "Don’t have an account?"
            val createText = " Create an account"
            val annotatedText = buildAnnotatedString {
                append(initText)
                withStyle(style = SpanStyle(color = PurpleMain)) {
                    pushStringAnnotation(tag = createText, annotation = createText)
                    append(createText)
                }
            }
            ClickableText(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 16.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(400),
                    color = Color(0x80000000),
                    textAlign = TextAlign.Center
                ),
                text = annotatedText, onClick = { offset ->
                    annotatedText.getStringAnnotations(offset, offset)
                        .firstOrNull()?.also { span ->
                            Log.d("ClickableTextComponent", "{${span.item}")
                            if (span.item == createText) {
                                navController.navigate(Screen.SignUp.route)
                            }
                        }
                })
        }
    }
}

@Preview
@Composable
fun LoginScreePreview() {
    LoginScreen(rememberNavController())
}