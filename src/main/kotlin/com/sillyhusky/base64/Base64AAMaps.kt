package com.sillyhusky.base64

class Base64AAMaps : Base64Maps {

    companion object {

        private val instance = Base64AAMaps()
        fun default(): Base64Maps {
            return instance
        }

        private val binToCharMap: Map<Int, Int> = mapOf(
            0 to 'A'.code, 1 to 'À'.code, 2 to 'Á'.code, 3 to 'Â'.code,
            4 to 'Ã'.code, 5 to 'Ä'.code, 6 to 'Å'.code, 7 to 'Ǎ'.code,
            8 to 'Ā'.code, 9 to 'Ă'.code, 10 to 'Ạ'.code, 11 to 'Ả'.code,
            12 to 'Ấ'.code, 13 to 'Ầ'.code, 14 to 'Ẩ'.code, 15 to 'Ẫ'.code,
            16 to 'Ậ'.code, 17 to 'Ắ'.code, 18 to 'Ằ'.code, 19 to 'Ẳ'.code,
            20 to 'Ẵ'.code, 21 to 'Ặ'.code, 22 to 'Ḁ'.code, 23 to 'Ȁ'.code,
            24 to 'Ȃ'.code, 25 to 'Ą'.code, 26 to 'Ǡ'.code, 27 to 'Ǟ'.code,
            28 to 'Ǻ'.code, 29 to 'Ȧ'.code, 30 to 'Ⱥ'.code, 31 to 'Ά'.code,
            32 to 'Α'.code, 33 to 'Ἀ'.code, 34 to 'Ἁ'.code, 35 to 'Ἂ'.code,
            36 to 'Ἃ'.code, 37 to 'ᾈ'.code, 38 to 'ᾉ'.code, 39 to 'ᾊ'.code,
            40 to 'ᾋ'.code, 41 to 'Ᾰ'.code, 42 to 'Ᾱ'.code, 43 to 'Ὰ'.code,
            44 to 'ᾼ'.code, 45 to 'А'.code, 46 to 'Ӑ'.code, 47 to 'Ӓ'.code,
            48 to 'Ӕ'.code, 49 to 'ƛ'.code, 50 to '⍙'.code, 51 to 'ᴀ'.code,
            52 to 'Ꜳ'.code, 53 to 'ᗅ'.code, 54 to 'ᗋ'.code, 55 to '↟'.code,
            56 to '⍲'.code, 57 to '⍋'.code, 58 to '▴'.code, 59 to '△'.code,
            60 to '⍝'.code,  61 to 'Ꜹ'.code, 62 to '⧋'.code, 63 to '⧊'.code
        )

        private val charToBinMap: Map<Int, Int> = mapOf(
            'A'.code to 0, 'À'.code to 1, 'Á'.code to 2, 'Â'.code to 3,
            'Ã'.code to 4, 'Ä'.code to 5, 'Å'.code to 6, 'Ǎ'.code to 7,
            'Ā'.code to 8, 'Ă'.code to 9, 'Ạ'.code to 10, 'Ả'.code to 11,
            'Ấ'.code to 12, 'Ầ'.code to 13, 'Ẩ'.code to 14, 'Ẫ'.code to 15,
            'Ậ'.code to 16, 'Ắ'.code to 17, 'Ằ'.code to 18, 'Ẳ'.code to 19,
            'Ẵ'.code to 20, 'Ặ'.code to 21, 'Ḁ'.code to 22, 'Ȁ'.code to 23,
            'Ȃ'.code to 24, 'Ą'.code to 25, 'Ǡ'.code to 26, 'Ǟ'.code to 27,
            'Ǻ'.code to 28, 'Ȧ'.code to 29, 'Ⱥ'.code to 30, 'Ά'.code to 31,
            'Α'.code to 32, 'Ἀ'.code to 33, 'Ἁ'.code to 34, 'Ἂ'.code to 35,
            'Ἃ'.code to 36, 'ᾈ'.code to 37, 'ᾉ'.code to 38, 'ᾊ'.code to 39,
            'ᾋ'.code to 40, 'Ᾰ'.code to 41, 'Ᾱ'.code to 42, 'Ὰ'.code to 43,
            'ᾼ'.code to 44, 'А'.code to 45, 'Ӑ'.code to 46, 'Ӓ'.code to 47,
            'Ӕ'.code to 48, 'ƛ'.code to 49, '⍙'.code to 50, 'ᴀ'.code to 51,
            'Ꜳ'.code to 52, 'ᗅ'.code to 53, 'ᗋ'.code to 54, '↟'.code to 55,
            '⍲'.code to 56, '⍋'.code to 57, '▴'.code to 58, '△'.code to 59,
            '⍝'.code to 60, 'Ꜹ'.code to 61, '⧋'.code to 62, '⧊'.code to 63
        )

    }

    override fun getBinToCharMap(): Map<Int, Int> {
        return binToCharMap
    }

    override fun getCharToBinMap(): Map<Int, Int> {
        return charToBinMap
    }

}