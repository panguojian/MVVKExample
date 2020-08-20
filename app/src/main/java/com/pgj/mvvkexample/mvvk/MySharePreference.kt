package com.pgj.mvvkexample.mvvk

import android.content.Context
import android.os.Parcelable
import com.tencent.mmkv.MMKV


/**
 * Created by pgj on 2020/1/13.
 */
object MySharePreference  {
    const val SP_FILE_NAME  = "home_accelerator_content_sp"
    const val ID= "homeAccelerator"
    var mmkv: MMKV? = null


    fun initMMKV(context: Context) {
        if (null == mmkv) {
            MMKV.initialize(context);
            mmkv = MMKV.mmkvWithID(ID)
        }

    }

    fun putString(context: Context, key: String, data: String) {
        initMMKV(context)
        mmkv?.encode(key, data)
    }

    fun getString(context: Context, key: String, default: String? = ""): String {
        initMMKV(context)
        return mmkv!!.decodeString(key, default)
    }

    fun putLong(context: Context, key: String, value: Long) {
        initMMKV(context)
        mmkv!!.encode(key, value)
    }

    fun getLong(context: Context, key: String, default: Long = 0): Long {
        initMMKV(context)
        return mmkv!!.decodeLong(key, default)
    }

    fun putInt(context: Context, key: String, value: Int) {
        initMMKV(context)
        mmkv!!.encode(key, value)
    }

    fun getInt(context: Context, key: String, default: Int = 0): Int {
        initMMKV(context)
        return mmkv!!.decodeInt(key, default)
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        initMMKV(context)
        mmkv!!.encode(key, value)
    }

    fun getBoolean(context: Context, key: String, default: Boolean = false): Boolean {
        initMMKV(context)
        return mmkv!!.decodeBool(key, default)
    }

    fun putObject(context: Context, key: String, parcelableValue:Parcelable){
        initMMKV(context)
        mmkv!!.encode(key, parcelableValue)
    }
    fun <T:Parcelable>getObject(context: Context, key: String, clazz: Class<T>): T?{
        initMMKV(context)
        return mmkv!!.decodeParcelable(key, clazz)
    }
    fun removeObject(context: Context, key: String){
        initMMKV(context)
        mmkv!!.remove(key)
    }

    fun containKey(context: Context, key: String): Boolean {
        initMMKV(context)
        return mmkv!!.containsKey(key)
    }
}