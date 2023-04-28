package com.sillyhusky.util

import java.io.ByteArrayOutputStream
import java.util.zip.Deflater
import java.util.zip.Inflater

class ZipUtils {

    companion object {
        fun zip(data: ByteArray): ByteArray {
            val deflater = Deflater()
            deflater.setInput(data)
            deflater.finish()

            val compressed = ByteArrayOutputStream()
            val buffer = ByteArray(1024)

            while (!deflater.finished()) {
                val compressedLength = deflater.deflate(buffer)
                compressed.write(buffer, 0, compressedLength)
            }

            deflater.end()

            return compressed.toByteArray()
        }

        fun unzip(data: ByteArray): ByteArray {
            val inflater = Inflater()
            inflater.setInput(data)

            val decompressed = ByteArrayOutputStream()
            val buffer = ByteArray(1024)

            while (!inflater.finished()) {
                val decompressedLength = inflater.inflate(buffer)
                decompressed.write(buffer, 0, decompressedLength)
            }

            inflater.end()

            return decompressed.toByteArray()
        }
    }

}