package com.example.simplefund2

import android.app.Activity
import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Currency & Percent Format
 */
const val ANSI_CURRENCY_FORMAT = "#,##0.00;-#,##0.00"
const val IDN_CURRENCY_FORMAT = "#.##0,00;-#.##0,00"
const val ANSI_PERCENT_FORMAT = "#,##0.00 %;-#,##0.00 %"
const val IDN_PERCENT_FORMAT = "#.##0,00 %;-#.##0,00 %"
val CurrFmt = DecimalFormat(ANSI_CURRENCY_FORMAT)
val PercentFmt = DecimalFormat(ANSI_PERCENT_FORMAT)

/**
 * Date Format
 */
const val ANSI_DATE_FORMAT = "yyyy-MM-dd"
const val ANSI_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"  // 2018-01-15 21:35:00
const val ANSI_DATETIME_FORMAT_WITH_MS = "yyyy-MM-dd HH:mm:ss.SSS"  // 2015-01-01 00:00:00.000
const val EUROPE_DATE_FORMAT = "dd.MM.yyyy"
const val IDN_DATE_FORMAT = "dd-MM-yyyy"
const val FORM_DATE_FORMAT = "dd-MMM-yyyy"
val DateFmt = SimpleDateFormat(IDN_DATE_FORMAT)
val FormDateFmt = SimpleDateFormat(FORM_DATE_FORMAT)

var isLogin = false
val jRequest = JSONObject()
val jParams = JSONObject()
val sRandom = Random()
var aMain = Activity()

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // ... Initialization Realm Database
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("simpleFund.realm").schemaVersion(1).deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)

    }
}