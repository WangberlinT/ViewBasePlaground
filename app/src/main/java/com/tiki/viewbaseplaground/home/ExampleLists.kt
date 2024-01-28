package com.tiki.viewbaseplaground.home

data class Example(
    val title: String,
    val description: String,
    val destination: String
)

val EXAMPLES = listOf(
    Example(
        title = "How Android touch events are dispatched",
        description = "In this article, I will elaborate on how touch events are dispatched and handled in the Android view tree.",
        destination = Destinations.eventDispatching
    ),
    Example(
        title = "How to intercept touch event in ViewPager2",
        description = "test",
        destination = Destinations.viewPagerIntercept
    ),
)
