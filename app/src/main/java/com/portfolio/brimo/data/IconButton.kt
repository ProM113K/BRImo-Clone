package com.portfolio.brimo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class IconButton(
    @DrawableRes val logo: Int,
    @StringRes val title: Int,
    @StringRes val subTitle: Int,
    val navRoute: String
)
