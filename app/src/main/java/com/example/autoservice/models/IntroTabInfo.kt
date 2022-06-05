package com.example.autoservice.models

import android.os.Parcel
import android.os.Parcelable

data class IntroTabInfo(
    var title: String,
    var image: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IntroTabInfo> {
        override fun createFromParcel(parcel: Parcel): IntroTabInfo {
            return IntroTabInfo(parcel)
        }

        override fun newArray(size: Int): Array<IntroTabInfo?> {
            return arrayOfNulls(size)
        }
    }
}