package com.sillyhusky.base64

class Base64AAMaps : Base64Maps {

    companion object {

        private val instance = Base64AAMaps()
        fun default(): Base64Maps {
            return instance
        }

        private val binToCharMap: Map<Int, Char> = mapOf(
            0 to 'A', 1 to 'À', 2 to 'Á', 3 to 'Â', 4 to 'Ã', 5 to 'Ä', 6 to 'Å', 7 to 'Ǎ',
            8 to 'Ā', 9 to 'Ă', 10 to 'Ạ', 11 to 'Ả', 12 to 'Ấ', 13 to 'Ầ', 14 to 'Ẩ', 15 to 'Ẫ',
            16 to 'Ậ', 17 to 'Ắ', 18 to 'Ằ', 19 to 'Ẳ', 20 to 'Ẵ', 21 to 'Ặ', 22 to 'Ḁ', 23 to 'Ȁ',
            24 to 'Ȃ', 25 to 'Ą', 26 to 'Ǡ', 27 to 'Ǟ', 28 to 'Ǻ', 29 to 'Ȧ', 30 to 'Ⱥ', 31 to 'Ά',
            32 to 'Α', 33 to 'Ἀ', 34 to 'Ἁ', 35 to 'Ἂ', 36 to 'Ἃ', 37 to 'ᾈ', 38 to 'ᾉ', 39 to 'ᾊ',
            40 to 'ᾋ', 41 to 'Ᾰ', 42 to 'Ᾱ', 43 to 'Ὰ', 44 to 'ᾼ', 45 to 'А', 46 to 'Ӑ', 47 to 'Ӓ',
            48 to 'Ӕ', 49 to 'ƛ', 50 to '⍙', 51 to 'ᴀ', 52 to 'Ꜳ', 53 to 'ᗅ', 54 to 'ᗋ', 55 to '↟',
            56 to '⍲', 57 to '⍋', 58 to '▴', 59 to '△', 60 to '⍝',  61 to 'Ꜹ', 62 to '⧋', 63 to '⧊'
        )

        private val charToBinMap: Map<Char, Int> = mapOf(
            'A' to 0, 'À' to 1, 'Á' to 2, 'Â' to 3, 'Ã' to 4, 'Ä' to 5, 'Å' to 6, 'Ǎ' to 7,
            'Ā' to 8, 'Ă' to 9, 'Ạ' to 10, 'Ả' to 11, 'Ấ' to 12, 'Ầ' to 13, 'Ẩ' to 14, 'Ẫ' to 15,
            'Ậ' to 16, 'Ắ' to 17, 'Ằ' to 18, 'Ẳ' to 19, 'Ẵ' to 20, 'Ặ' to 21, 'Ḁ' to 22, 'Ȁ' to 23,
            'Ȃ' to 24, 'Ą' to 25, 'Ǡ' to 26, 'Ǟ' to 27, 'Ǻ' to 28, 'Ȧ' to 29, 'Ⱥ' to 30, 'Ά' to 31,
            'Α' to 32, 'Ἀ' to 33, 'Ἁ' to 34, 'Ἂ' to 35, 'Ἃ' to 36, 'ᾈ' to 37, 'ᾉ' to 38, 'ᾊ' to 39,
            'ᾋ' to 40, 'Ᾰ' to 41, 'Ᾱ' to 42, 'Ὰ' to 43, 'ᾼ' to 44, 'А' to 45, 'Ӑ' to 46, 'Ӓ' to 47,
            'Ӕ' to 48, 'ƛ' to 49, '⍙' to 50, 'ᴀ' to 51, 'Ꜳ' to 52, 'ᗅ' to 53, 'ᗋ' to 54, '↟' to 55,
            '⍲' to 56, '⍋' to 57, '▴' to 58, '△' to 59, '⍝' to 60, 'Ꜹ' to 61, '⧋' to 62, '⧊' to 63
        )

    }

    override fun getBinToCharMap(): Map<Int, Char> {
        return binToCharMap
    }

    override fun getCharToBinMap(): Map<Char, Int> {
        return charToBinMap
    }

}