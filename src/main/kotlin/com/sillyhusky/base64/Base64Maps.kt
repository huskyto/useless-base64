package com.sillyhusky.base64

interface Base64Maps {

    fun getBinToCharMap(): Map<Int, Int>
    fun getCharToBinMap(): Map<Int, Int>

}