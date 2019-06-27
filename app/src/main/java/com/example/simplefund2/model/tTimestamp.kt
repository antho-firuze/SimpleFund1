package com.example.simplefund2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by antho.firuze@gmail.com on 14/05/2019.
 */

@Parcelize
data class tTimestamp(
//    val id: String = UUID.randomUUID().toString(),
    val field: String = "",
    val timestamp: Date? = null
): Parcelable {
    var id: String = UUID.randomUUID().toString()
    var created_at: Date = Date()
    companion object {
        val TABLE_NAME = "tTimestamp"
    }
}