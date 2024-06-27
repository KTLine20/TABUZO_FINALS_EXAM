
package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

/**
 * A data class to represent the information presented in the dog card
 */
/* dito minamanage yung images sa 3rd page*/

data class spots(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val loc: Int,
    @StringRes val hobbies: Int
)

val bspot = listOf(


    spots(R.drawable.cagsawa_ruins, R.string.spot_1,R.string.Location1, R.string.Description_1),
    spots(R.drawable.daraga_church, R.string.spot_2, R.string.Location2, R.string.Description_2),
    spots(R.drawable.minorbasilica, R.string.spot_3, R.string.Location3, R.string.Description_3),
    spots(R.drawable.rizal_beach, R.string.spot_4, R.string.Location4, R.string.Description_4),
    spots(R.drawable.subic_beach, R.string.spot_5, R.string.Location5, R.string.Description_5),
    spots(R.drawable.verafalls, R.string.spot_6, R.string.Location6, R.string.Description_6),
    spots(R.drawable.lignonhill, R.string.spot_7, R.string.Location7, R.string.Description_7),
    spots(R.drawable.calaguas, R.string.spot_8, R.string.Location8, R.string.Description_8),
    spots(R.drawable.caramoan, R.string.spot_9, R.string.Location9, R.string.Description_9),
    spots(R.drawable.bagabas, R.string.spot_10, R.string.Location10, R.string.Description_10)

)