package com.example.swaragroup.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.swaragroup.R
import com.example.swaragroup.navigation.Screen
import com.example.swaragroup.util.OnBoardingPage
import com.example.swaragroup.viewmodel.OnBoardingViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()

    val isSkipVisible = remember {
        derivedStateOf {
            pagerState.currentPage != pages.size - 1
        }
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PageScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
            activeColor = colorResource(id = R.color.purple_main)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(265.dp, 47.dp)
                .padding(start = 63.dp, end = 62.dp, bottom = 20.dp)
                .weight(1f)
                .heightIn(max = 47.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                scope.launch {
                    if (pagerState.currentPage != 2) {
                        pagerState.animateScrollToPage(pagerState.currentPage+1)
                    } else {

                        navController.navigate(Screen.Login.route)
                    }
                }
                onBoardingViewModel.saveOnBoardingState(complete = true)
                navController.popBackStack()
                      },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = colorResource(id = R.color.purple_main)
            ),
            shape = CircleShape,
            elevation = ButtonDefaults.elevation(0.dp,0.dp)
        ) {
            Text(text = "Next")
        }
        if (isSkipVisible.value) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .defaultMinSize(265.dp, 47.dp)
                    .heightIn(max = 47.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 63.dp, end = 62.dp, bottom = 20.dp),
                onClick = {
                    scope.launch {
                        navController.navigate(Screen.Login.route)
                    }
                    onBoardingViewModel.saveOnBoardingState(complete = true)
                    navController.popBackStack()
                },
                shape = CircleShape,
                border = BorderStroke(1.dp,MaterialTheme.colors.primary),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.purple_main),
                    backgroundColor = Color.White
                ),
            ) {
                Text(text = "Skip")
            }
        }

    }
}

@Composable
fun PageScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.6f)
                .padding(start = 32.dp, end = 31.dp)
                .defaultMinSize(327.dp, 272.dp),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(274.dp, 64.dp),
            style = TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center
            ),
            text = onBoardingPage.title
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(290.dp, 66.dp)
                .padding(start = 50.dp, end = 50.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF686868),

                textAlign = TextAlign.Center,
            ),
            text = onBoardingPage.description
        )

    }
}



@Composable
@Preview(showBackground = true)
fun PageScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PageScreen(onBoardingPage = OnBoardingPage.First)
    }
}


@Composable
@Preview(showBackground = true)
fun PageScreenPreview2() {
    Column(modifier = Modifier.fillMaxSize()) {
        PageScreen(onBoardingPage = OnBoardingPage.Second)
    }
}


@Composable
@Preview(showBackground = true)
fun PageScreenPreview3() {
    Column(modifier = Modifier.fillMaxSize()) {
        PageScreen(onBoardingPage = OnBoardingPage.Third)
    }
}