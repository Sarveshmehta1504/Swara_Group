package com.example.swaragroup.util

import androidx.annotation.DrawableRes
import com.example.swaragroup.R

sealed class OnBoardingPage (
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
    ){
        object First: OnBoardingPage(
            image = R.drawable.intro_image_1,
            title = "Future Living Unveiled",
            description = "Neighborly connections, information sharing, simplified communication"
        )
        object Second: OnBoardingPage(
            image = R.drawable.intro_image_2,
            title = "Empower Through Connectivity",
            description = "Build community strength with effortless connectivity, fostering unity among neighbors"
        )
        object Third: OnBoardingPage(
            image = R.drawable.intro_image_3,
            title = "Gateway to Informed Living",
            description = "Open the door to informed living, ensuring clarity and timely updates for a better community experience"
        )

}