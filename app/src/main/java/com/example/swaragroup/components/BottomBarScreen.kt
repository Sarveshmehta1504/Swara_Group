package com.example.swaragroup.components

import com.example.swaragroup.R

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.home,
        icon_focused = R.drawable.home
    )

    object Chat: BottomBarScreen(
        route = "chat",
        title = "Chat",
        icon = R.drawable.message,
        icon_focused = R.drawable.message
    )

    object Notice: BottomBarScreen(
        route = "notice",
        title = "Notice",
        icon = R.drawable.notice,
        icon_focused = R.drawable.notice
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.account,
        icon_focused = R.drawable.account
    )
}