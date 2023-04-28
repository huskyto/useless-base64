package com.sillyhusky.base64

import kotlinx.cli.*

enum class MapType {
    dot,
    aa,
    emoji
}

class CLArguments(parser: ArgParser) {
    val inputFile by parser.option(ArgType.String, shortName = "if", description = "Input file")
    val outputFile by parser.option(ArgType.String, shortName = "of", description = "Output file")
    val map by parser.option(ArgType.Choice<MapType>(), shortName = "m", description = "Internal map (dot, aa, emoji)")
    val customMap by parser.option(ArgType.String, shortName = "p", description = "Custom map pattern")//.restrictTo(length = 64)
    val compress by parser.option(ArgType.Boolean, shortName = "c", description = "Compress input").default(false)
    val encode by parser.option(ArgType.Boolean, shortName = "e", description = "Encode input").default(false)
    val decode by parser.option(ArgType.Boolean, shortName = "d", description = "Decode input").default(false)
    val verbose by parser.option(ArgType.Boolean, shortName = "v", description = "Verbose output").default(false)
//    val help by parser.option(ArgType.Boolean, shortName = "h", fullName = "help", description = "Show help information").default(false)
    val inputText by parser.argument(ArgType.String, description = "Input text").optional()
}