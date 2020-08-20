package com.pgj.mvvkexample.model

import android.os.Parcel
import android.os.Parcelable

/**
 *Created by pgj
 **/
data class AppList(var apps:List<App>?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(App.CREATOR)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(apps)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppList> {
        override fun createFromParcel(parcel: Parcel): AppList {
            return AppList(parcel)
        }

        override fun newArray(size: Int): Array<AppList?> {
            return arrayOfNulls(size)
        }
    }
}