package com.tiki.viewbaseplaground.home

data class ExampleItem(
    val title: String,
    val description: String,
    val destination: String
)

val EXAMPLES = listOf(
    ExampleItem(
        title = "How Android view handle touch events",
        description = "In this article I will elaborate how touch event is propagated in Android view-based system. ",
        destination = Destinations.eventDispatching
    ),
    ExampleItem(
        title = "How to intercept touch event in ViewPager2",
        description = "test",
        destination = Destinations.viewPagerIntercept
    ),
)
