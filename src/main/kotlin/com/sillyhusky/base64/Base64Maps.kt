package com.sillyhusky.base64

interface Base64Maps {

    fun getBinToCharMap(): Map<Int, Char>
    fun getCharToBinMap(): Map<Char, Int>

}