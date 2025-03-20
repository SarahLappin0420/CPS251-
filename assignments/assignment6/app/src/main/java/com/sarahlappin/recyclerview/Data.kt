package com.sarahlappin.recyclerview

data class RandomItem(
    val title: String, // Title of the item
    val detail: String, // Detail of the item
    val imageResId: Int

)
    class Data {

    val titles = arrayOf(
        "Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight"
    )

    val details = arrayOf(
        "Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details"
    )

    val images = intArrayOf(
        R.mipmap.image1,
        R.mipmap.image2, R.mipmap.image3,
        R.mipmap.image4, R.mipmap.image5,
        R.mipmap.image6, R.mipmap.image7,
        R.mipmap.image8
    )
}
