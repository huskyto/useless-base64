import com.sillyhusky.base64.*
import com.sillyhusky.util.ZipUtils
import kotlinx.cli.ArgParser
import java.io.File

fun main(args: Array<String>) {
    val parser = ArgParser("ulb64", useDefaultHelpShortName = true)
    val arguments = CLArguments(parser)

    try {
        parser.parse(args)
    } catch (e: Exception) {
        println("Error parsing arguments: ${e.message}")
        return
    }

        // Incompatibility checks //
    if (arguments.map != null && arguments.customMap != null) {
        println("Incompatible flags: -m and -p")
        return
    }

    if (arguments.inputText != null && arguments.inputFile != null) {
        println("Incompatible arguments: 'input text' and -if")
        return
    }

    if (arguments.encode && arguments.decode) {
        println("Incompatible flags: -e and -d")
        return
    }

        // INPUT //
    val textInput = arguments.inputText
    var input: ByteArray = if (textInput == null) {
        if (arguments.inputFile == null) {
            println("No input text or file")
            return
        }
        val inputFile = File(arguments.inputFile!!)
        if (!inputFile.exists()) {
            println("Input file $inputFile doesn't exist")
            return
        }
        inputFile.readBytes()
    }
    else {
        textInput.toByteArray()
    }

        // MAPS //
    val maps: Base64Maps = if (arguments.map != null) {
        when (arguments.map!!) {
            MapType.dot -> Base64DotMaps.default()
            MapType.aa -> Base64AAMaps.default()
            MapType.emoji -> {
                val emojiCode = "🐺🐵🐶🦊🐱🦁🐯🐴🦄🐮🐷🐻🐨🐼🦔🦘🦌🐿️🦏🦍🦡🦒🐪🐫🦙🐘🦛🐋🦈🐊🐢🦕🦖🐍🦎🐸🐉🐲🦚🦜🦢🦩🐾🦦🦧🦥🐁🐀🐇🍁🦉🦆🐃🦝🍑🍆🐆💦😺🌈🐜🐝🦗"
                Base64MapsFactory(emojiCode)
            }
        }
    }
    else if (arguments.customMap != null) {
        Base64MapsFactory(arguments.customMap!!)
    }
    else {
        println("No map selected or provided")
        return
    }


    if (arguments.encode) {
        if (arguments.compress) input = ZipUtils.zip(input)
        val encoded = Base64EncDec.encode(input, maps)

        processOutput(arguments, encoded.toByteArray())
    }
    else if (arguments.decode) {
        var decoded = Base64EncDec.decode(String(input), maps)
        if (arguments.compress) decoded = ZipUtils.zip(decoded)

        processOutput(arguments, decoded)
    }
    else {
        println("No option for encode/decode")
    }
}

private fun processOutput(arguments: CLArguments, data: ByteArray) {
    if (arguments.outputFile != null) {
        val outputFile = File(arguments.outputFile!!)
        outputFile.writeBytes(data)
    } else {
        println(String(data))
    }
}

