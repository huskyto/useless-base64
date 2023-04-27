package com.sillyhusky.base64

class Base64EncDec {

    companion object {

        private const val PAD_CHAR = '—'

        fun encode(input: ByteArray, maps: Base64Maps): String {
            val charMap = maps.getBinToCharMap()
            val output = StringBuilder()
            var i = 0

            while (i < input.size) {
                val b0 = input[i++].toInt() and 0xFF
                val hasB1 = i < input.size
                val b1 = if (hasB1) input[i++].toInt() and 0xFF else 0
                val hasB2 = i < input.size
                val b2 = if (hasB2) input[i++].toInt() and 0xFF else 0

                val index0 = b0 shr 2
                val index1 = ((b0 and 0x03) shl 4) or (b1 shr 4)
                val index2 = ((b1 and 0x0f) shl 2) or (b2 shr 6)
                val index3 = b2 and 0x3f

                output.append(charMap[index0])
                output.append(charMap[index1])
                output.append(if (hasB1) charMap[index2] else PAD_CHAR)
                output.append(if (hasB2) charMap[index3] else PAD_CHAR)
            }

            return output.toString()
        }

        fun decode(input: String, maps: Base64Maps): ByteArray {
            val decodeMap = maps.getCharToBinMap()
            if (input.length % 4 != 0) {
                throw IllegalArgumentException("Invalid Base64 input length")
            }

            val output = ByteArray(input.length / 4 * 3)
            var outIdx = 0
            var i = 0

            while (i < input.length) {
                val ch0 = getCharValue(i++, input, decodeMap)
                val ch1 = getCharValue(i++, input, decodeMap)
                val ch2 = getCharValue(i++, input, decodeMap)
                val ch3 = getCharValue(i++, input, decodeMap)

                val b0 = (ch0 shl 2) or (ch1 shr 4)
                val b1 = if (ch2 != -1) ((ch1 and 0x0f) shl 4) or (ch2 shr 2) else -1
                val b2 = if (ch3 != -1) ((ch2 and 0x03) shl 6) or ch3 else -1

                output[outIdx++] = b0.toByte()
                if (b1 != -1) output[outIdx++] = b1.toByte()
                if (b2 != -1) output[outIdx++] = b2.toByte()
            }

            return output.copyOf(outIdx)
        }

        private fun getCharValue(idx: Int, input: String, map: Map<Char, Int>): Int {
            return if (input[idx] != PAD_CHAR) {
                map[input[idx]] ?: throw IllegalArgumentException("Invalid Base64 character")
            }

            else { -1 }
        }

        private fun generateMaps(input: String): Pair<Map<Int, Char>, Map<Char, Int>>? {
            if (input.length != 64) {
                println("Error: Input string must contain exactly 64 characters. This has ${input.length}")
                return null
            }

            val charSet = input.toSet()
            if (charSet.size != 64) {
                val duplicates = input.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
                println("Error: Input string contains duplicate characters: $duplicates")
                return null
            }

            val decodeMap = input.mapIndexed { index, char -> char to index }.toMap()
            val encodeMap = decodeMap.entries.associateBy({ it.value }, { it.key })

            return Pair(encodeMap, decodeMap)
        }

    }

}