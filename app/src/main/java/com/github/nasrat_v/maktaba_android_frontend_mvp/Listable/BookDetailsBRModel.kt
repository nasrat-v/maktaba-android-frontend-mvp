package com.github.nasrat_v.maktaba_android_frontend_mvp.Listable

import android.os.Parcel
import android.os.Parcelable
import com.github.nasrat_v.maktaba_android_frontend_mvp.Listable.Book.Vertical.ListModel.ListBModel
import com.github.nasrat_v.maktaba_android_frontend_mvp.Listable.Review.Vertical.RModel

data class BookDetailsBRModel(
    var books: ArrayList<ListBModel>,
    var reviews: ArrayList<RModel>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        arrayListOf<ListBModel>().apply {
            parcel.readList(this, ListBModel::class.java.classLoader)
        },
        arrayListOf<RModel>().apply {
            parcel.readList(this, RModel::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeList(books)
        parcel.writeList(reviews)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookDetailsBRModel> {
        override fun createFromParcel(parcel: Parcel): BookDetailsBRModel {
            return BookDetailsBRModel(parcel)
        }

        override fun newArray(size: Int): Array<BookDetailsBRModel?> {
            return arrayOfNulls(size)
        }
    }
}