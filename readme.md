# Useless Base 64

Useless Base 64 is a fun and educational project created to explore and learn how Base64 encoding and decoding works. It features the ability to use a variety of silly character sets for encoding and decoding data. If you enjoy seeing one kind of data represented as something else, you'll find this project interesting.

Please note that this project is not meant for practical use. Since it uses Unicode characters, the encoded output has a large overhead. Although compression has been added to try to offset this issue, it's still not an ideal solution.

You can use this project to encode and decode regular Base64, or to use your own base64 encoding schemes.

Examples using the built-in maps:

`Dot`:

```
‼•⁅˘⁋•¬≅⁉ˇ∙˛⁋‼:⁅⁌̣⁅˘⁉⁇⋅̅‧-∙″⁌̣⁄≅⋅¯⋇″
```

`AA`:

```
ẰÅẶᾼǞÅ⍝ΑĄᾊĂӒǞẰÀẶǺᗋẶᾼĄȀẦᴀĀÃĂἈǺᗋẴΑẦἊẬἈ
```

`Emoji`:

```
️🐯🦡🦦🦛🐯🌈🦕🦙🦚🐮🐁🦛️🐵🦡🐋🦝🦡🦦🦙🐪🐼🦉🦄🐱🐮🦖🐋🦝🦍🦕🐼🦎🦌🦖
```

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [How to Use](#how-to-use)
- [Disclaimer](#disclaimer)
- [License](#license)
- [NAQ (Nobody Asked Questions)](#naq--nobody-asked-questions-)
- [Author Notes](#author-notes)

## Features

- Custom Base64 encoding and decoding.
- Support for unicode character sets.
- Optional compression.

## Installation

### Option 1: Clone and build it yourself.

1. Clone the repository:

```
git clone https://github.com/huskyto/useless-base64.git
```

2. Change to the project directory:

```
cd useless-base64
```

3. Build the project and create a JAR file:

```
./gradlew clean shadowJar
```

4. The JAR file will be located in the `build/libs` directory.

### Option 2: Use the provided jar in the `jars` folder.

Inside the `jars` folder there will be a built fat jar (`ulb64.jar`). You can use that instead of building your own.

You can also use the `ulb64.sh` or `ulb64.bat` scripts to run it in a shorter syntax:

```
./ulb64.sh
```

Would replace:

```
java -jar ulb64.jar
```

## How to Use

1. Execute the JAR file with the appropriate command-line arguments:

```
java -jar useless-base64-(...)-all.jar [options] [input]
```

Replace `useless-base64-(...)-all.jar` with the name of the generated JAR file.

If using the pre-compiled jar, or one of the scripts, use that instead.

### Options

- `-if some-file`: Input file
- `-of some-file`: Output file
- `-m dot | aa | emoji`: Mode (choose one of "dot", "aa", or "emoji")
- `-p some-string`: Custom pattern (length must be 64 characters)
- `"some text"`: Input text (incompatible with `-if`)
- `-c`: Compress input
- `-e`: Encode input
- `-d`: Decode input (incompatible with `-e`)
- `-v`: Verbose output

For more help, use the `-h` flag:

```
java -jar build/libs/your-jar-file-all.jar -h
```

### Examples

Examples show how to use it for text, for simplicity; however it can be used in the same way for any binary file.

#### Encode using an internal map

```
java -jar jarname.jar -e -m dot "Hello world!"
```

This result will probably not display in the console, so using an output file is recommended:

```
java -jar jarname.jar -e -m dot -of "encoded.txt" "Hello world!"
```

When you open the file, you should see this result:

```
‼•⁅˘⁋•¬≅⁍̣≡̄⁋•⋇″
```

Change the `dot` after `-m` for the other built-in maps. Right now, `dot`, `aa` and `emoji` are the available options.

#### Decode using an internal map.

Using the file from the previous steps:

```
java -jar jarname.jar -d -m dot -if "encoded.txt" -of "decoded.txt"
```

The new output file (decoded.txt) should contain:

```
Hello world!
```

#### Using your own map

You can also use your own map with this encoder/decoder. For example, you can use it to encode one of the standard base64, like this:

```
java -jar jarname.jar -e -p "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/" "Hello world!"
```

For this result:

```
SGVsbG8gd29ybGQh
```

## Disclaimer

This project is for fun and educational purposes only. It is not intended for practical use due to its large overhead when encoding data. For standard Base64 encoding and decoding, use an existing library or tool.

## License

Useless Base 64 is released under the Apache License 2.0 license.

### Summary

- You are free to use, modify, and distribute this software.
- If you modify the software or create a derivative work, you must include the original copyright notice and a notice of the changes you made.
- The software is provided "as is," without warranties of any kind.

## NAQ (Nobody Asked Questions)

#### Why did you make this thing?

I love seeing information being encoded or displayed as something different, and this seemed like a good way to do it. I also wanted to know how encoding in base64 (or some other base) worked under the hood, so this seemed like a good way to explore it.

#### Hey, I created my own map for encoding/decoding which I'm proud of, could you include it here?

Sure thing! send it to me, and I will find a way to include it.

#### Will you make a Rust version of this project?

Possibly. Not sure yet. But let me know if you would like that, so it will move it up my priority list.

#### If I ask a question, will you make a FAQ, or would it be in the NAQ?

I will add a SAQ, I guess!

## Author notes

- Any feedback and suggestions are welcome. Constructive criticism is very welcomed, but please make sure you at least read through the readme before saying things like "this is useless", or similar.

- If you use this project, let me know! I would specially like to see if you make your own map for encoding/decoding. If you want to, you can send me the map and I can include it as some optional map!


