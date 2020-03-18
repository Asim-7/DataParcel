package com.shehzad.dataparcel

import android.os.Parcel
import android.os.Parcelable

class ExampleItem() : Parcelable{
    private var mImageResource = 0
    private var mText1: String? = null
    private var mText2: String? = null

    constructor(mImg:Int, txt1:String, txt2:String) : this() {
        mImageResource = mImg
        mText1 = txt1
        mText2 = txt2
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeInt(mImageResource)
        dest.writeString(mText1)
        dest.writeString(mText2)
    }

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getText1(): String? {
        return mText1
    }

    fun getText2(): String? {
        return mText2
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExampleItem> {
        override fun createFromParcel(parcel: Parcel): ExampleItem {
            return ExampleItem(parcel)
        }

        override fun newArray(size: Int): Array<ExampleItem?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this() {
        mImageResource = parcel.readInt()
        mText1 = parcel.readString()
        mText2 = parcel.readString()
    }
}