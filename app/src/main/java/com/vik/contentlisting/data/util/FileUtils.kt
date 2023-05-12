package com.vik.contentlisting.data.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vik.contentlisting.R
import com.vik.contentlisting.domain.model.Page
import com.vik.contentlisting.domain.model.PageX
import java.io.IOException

object FileUtils {

    @SuppressLint("DiscouragedApi")
    fun getExistingDrawable(drawableName: String, context: Context) : Int{
       return when(drawableName) {
            "poster1.jpg" -> R.drawable.poster1
            "poster2.jpg" -> R.drawable.poster2
            "poster3.jpg" -> R.drawable.poster3
            "poster4.jpg" -> R.drawable.poster4
            "poster5.jpg" -> R.drawable.poster5
            "poster6.jpg" -> R.drawable.poster6
            "poster7.jpg" -> R.drawable.poster7
            "poster8.jpg" -> R.drawable.poster8
            "poster9.jpg" -> R.drawable.poster9
            else -> {
                0
            }
        }
    }
    fun parseJson(context: Context, fileName: String): PageX {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open(fileName)
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("File Utils", "JsonParsing: ${ioException.message}")
        }
        val listCountryType = object : TypeToken<Page>() {}.type
        val page =  Gson().fromJson<Page>(jsonString, listCountryType)
        return page.page
    }
}