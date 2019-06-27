package com.example.simplefund2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by antho.firuze@gmail.com on 14/05/2019.
 */

@Parcelize
data class tUser(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val email: String = "",
    val token: String = "",
    val token_exp: Date? = null
): Parcelable {
    var created_at: Date = Date()
    companion object {
        val TABLE_NAME = "tUsers"
    }
}