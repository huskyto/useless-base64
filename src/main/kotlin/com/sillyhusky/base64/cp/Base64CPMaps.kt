package com.sillyhusky.base64.cp

interface Base64CPMaps {

    fun getBinToCharMap(): Map<Int, Int>
    fun getCharToBinMap(): Map<Int, Int>

}