package com.example.simplefund2.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.simplefund2.model.tTimestamp
import com.example.simplefund2.model.tUser
import org.jetbrains.anko.db.*

/**
 * Created by antho.firuze@gmail.com on 16/05/2019.
 */

class DBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "SimpleFund1DB", null, 1) {
    companion object {
        private var instance: DBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DBHelper {
            if (instance == null) {
                instance = DBHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(tUser.TABLE_NAME, true,
            "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "name" to TEXT,
            "email" to TEXT,
            "token" to TEXT,
            "token_exp" to INTEGER,
            "created_at" to INTEGER
        )
        db?.createTable(tTimestamp.TABLE_NAME, true,
            "id" to INTEGER + PRIMARY_KEY,
            "name" to TEXT,
            "email" to TEXT,
            "token" to TEXT,
            "token_exp" to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(tUser.TABLE_NAME)
        db?.dropTable(tTimestamp.TABLE_NAME)
    }

}

val Context.database: DBHelper
    get() = DBHelper.getInstance(this)
