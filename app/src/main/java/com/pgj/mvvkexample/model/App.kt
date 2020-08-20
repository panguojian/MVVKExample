package com.pgj.mvvkexample.model

import android.os.Parcel
import android.os.Parcelable

/**
 *Created by pgj
 **/
data class App(var id: Int?, var name: String?) : Parcelable {
    constructor(source: Parcel) : this(
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<App> = object : Parcelable.Creator<App> {
            override fun createFromParcel(source: Parcel): App = App(source)
            override fun newArray(size: Int): Array<App?> = arrayOfNulls(size)
        }
    }
}




