package com.sillyhusky.base64

class Base64MapsFactory : Base64Maps {

    private var binToCharMap: Map<Int, Char>
    private var charToBinMap: Map<Char, Int>

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

    override fun getBinToCharMap(): Map<Int, Char> {
        return binToCharMap
    }

    override fun getCharToBinMap(): Map<Char, Int> {
        return charToBinMap
    }

    private fun generateMaps(key: String): Pair<Map<Char, Int>, Map<Int, Char>>? {
        if (key.length != 64) {
            println("Error: Input string must contain exactly 64 characters.")
            return null
        }

        val charSet = key.toSet()
        if (charSet.size != 64) {
            val duplicates = key.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
            println("Error: Input string contains duplicate characters: $duplicates")
            return null
        }

        val encodeMap = key.mapIndexed { index, char -> char to index }.toMap()
        val decodeMap = encodeMap.entries.associateBy({ it.value }, { it.key })

        return Pair(encodeMap, decodeMap)
    }

}