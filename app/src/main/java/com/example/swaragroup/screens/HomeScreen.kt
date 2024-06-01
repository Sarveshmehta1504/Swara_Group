package com.example.swaragroup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swaragroup.R
import org.w3c.dom.Text

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter? = null,
    val unselectedIcon: Painter,
    val hasNews: Boolean
)


@Composable
fun HomeScreen(
    navController: NavController
) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.home),
            unselectedIcon = painterResource(id = R.drawable.home),
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Chat",
            selectedIcon = painterResource(id = R.drawable.message),
            unselectedIcon = painterResource(id = R.drawable.message),
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Notice",
            selectedIcon = painterResource(id = R.drawable.notice),
            unselectedIcon = painterResource(id = R.drawable.notice),
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Notice",
            selectedIcon = painterResource(id = R.drawable.account),
            unselectedIcon = painterResource(id = R.drawable.account),
            hasNews = false
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 23.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(34.dp)
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier.size(34.dp),
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "NotificationIcon"
                        )
                    }
                    Badge(
                        modifier = Modifier
                            .border(1.dp, color = Color.Black, shape = CircleShape)
                            .align(Alignment.TopEnd)
                            .clip(CircleShape),
                        content = {
                            Text(text = "3")
                        },
                        containerColor = Color.White,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.swara_logo_1),
                    modifier = Modifier.size(125.dp, 40.dp),
                    contentDescription = "swara logo"
                )
                Image(
                    modifier = Modifier.size(44.dp),
                    painter = painterResource(id = R.drawable.profile_pic_image),
                    contentDescription = "Profile Pic"
                )
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black
            ){
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index },
                        alwaysShowLabel = true,
                        label = {
                            Text(
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 22.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                ),
                                text = item.title
                            )
                        },
                        icon = {
                            (if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            })?.let {
                                Image(
                                    painter = it,
                                    contentDescription = item.title
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors()
                    )
                }
            }
        }
    ) { paddingItem ->
        Surface(
            modifier = Modifier
                .padding(paddingItem)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "HOME",
                    fontSize = MaterialTheme.typography.h4.fontSize
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
