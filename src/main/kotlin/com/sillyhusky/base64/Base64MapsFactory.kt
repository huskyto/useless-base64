package com.sillyhusky.base64

import kotlin.streams.toList

class Base64MapsFactory : Base64Maps {

    private var binToCharMap: Map<Int, Int>
    private var charToBinMap: Map<Int, Int>

    constructor(key: String) {
        val pair = generateMaps(key)
        if (pair != null) {
            binToCharMap = pair.second
            charToBinMap = pair.first
        }
        else {
            binToCharMap = mapOf()
            charToBinMap = mapOf()
        }
    }

    override fun getBinToCharMap(): Map<Int, Int> {
        return binToCharMap
    }

    override fun getCharToBinMap(): Map<Int, Int> {
        return charToBinMap
    }

    private fun generateMaps(key: String): Pair<Map<Int, Int>, Map<Int, Int>>? {
        val cps = key.codePoints().toList()
        if (cps.size != 64) {
            println("Error: Input string must contain exactly 64 characters. It has ${cps.size}")
            return null
        }

        val charSet = cps.toSet()
        if (charSet.size != 64) {
            val duplicates = cps.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
            println("Error: Input string contains duplicate characters: $duplicates")
            return null
        }

        val encodeMap = cps.mapIndexed { index, char -> char to index }.toMap()
        val decodeMap = encodeMap.entries.associateBy({ it.value }, { it.key })

        return Pair(encodeMap, decodeMap)
    }

}