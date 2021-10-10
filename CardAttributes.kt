package com.example.labact6_supplementary

import com.google.gson.annotations.SerializedName

class CardAttributes {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("author")
    var author: String? = null

    @SerializedName("width")
    var width: Int = 0

    @SerializedName("height")
    var height: Int = 0

    @SerializedName("url")
    var url: String? = null

    @SerializedName("download_url")
    var download_url: String? = null

}

