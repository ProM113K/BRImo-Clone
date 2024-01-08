package com.portfolio.brimo.data

import com.portfolio.brimo.R
import com.portfolio.brimo.ui.NavGraph

object IconButtonData {
    val setLoginIconButton = listOf(
        IconButton(
            logo = R.drawable.catatan_keuangan,
            title = R.string.catatan_keuangan,
            subTitle = R.string.empty,
            navRoute = NavGraph.CATATANKEUANGAN.name
        ),
        IconButton(
            logo = R.drawable.brizzi,
            title = R.string.brizzi,
            subTitle = R.string.empty,
            navRoute = NavGraph.BRIZZI.name
        ),
        IconButton(
            logo = R.drawable.dompet_digital,
            title = R.string.dompet_digital,
            subTitle = R.string.empty,
            navRoute = NavGraph.DOMPETDIGITAL.name
        ),
        IconButton(
            logo = R.drawable.pulsa_data,
            title = R.string.pulsa_data,
            subTitle = R.string.empty,
            navRoute = NavGraph.PULSADATA.name
        ),
        IconButton(
            logo = R.drawable.qris,
            title = R.string.qris,
            subTitle = R.string.empty,
            navRoute = NavGraph.QRIS.name
        ),
        IconButton(
            logo = R.drawable.setor_tunai,
            title = R.string.setor_tunai,
            subTitle = R.string.empty,
            navRoute = NavGraph.SETORTUNAI.name
        ),
    )

    val setTopUpIconButton = listOf(
        IconButton(
            logo = R.drawable.linkaja_logo,
            title = R.string.linkaja_dimas,
            subTitle = R.string.phone_number1,
            navRoute = ""
        ),
        IconButton(
            logo = R.drawable.gopay_logo,
            title = R.string.gopay_dimas,
            subTitle = R.string.phone_number2,
            navRoute = ""
        ),
        IconButton(
            logo = R.drawable.gopay_logo,
            title = R.string.gopay_dimas,
            subTitle = R.string.phone_number3,
            navRoute = ""
        ),
        IconButton(
            logo = R.drawable.shopeepay_logo,
            title = R.string.spay_dimas,
            subTitle = R.string.phone_number4,
            navRoute = ""
        )
    )
}