package com.vik.contentlisting.data.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
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
        return context.resources.getIdentifier(drawableName, "drawable", context.packageName)
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