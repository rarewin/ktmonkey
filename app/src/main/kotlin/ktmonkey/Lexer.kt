package ktmonkey

import ktmonkey.Token

public class Lexer(input: String) {

    var input = input

    fun next(): Token {

        // 空白文字を飛ばす
        input = input.dropWhile { it.isWhitespace() }

        val ch = input.take(1)

        input = input.drop(1)

        if (ch == "") {
            return Token(Token.Type.EoF, "")
        }

        return when (ch) {
            "=" -> Token(Token.Type.Assign, ch)
            "+" -> Token(Token.Type.Plus, ch)
            "(" -> Token(Token.Type.LParen, ch)
            ")" -> Token(Token.Type.RParen, ch)
            "{" -> Token(Token.Type.LBrace, ch)
            "}" -> Token(Token.Type.RBrace, ch)
            "," -> Token(Token.Type.Comma, ch)
            ";" -> Token(Token.Type.Semicolon, ch)
            in "a".."z", in "A".."Z" -> {
                var word = ch

                word += input.takeWhile { it.isLetter() }
                input = input.dropWhile { it.isLetter() }

                when (word) {
                    "let" -> Token(Token.Type.Let, word)
                    else -> Token(Token.Type.Ident, word)
                }
            }
            in "0".."9" -> {
                var figure = ch

                figure += input.takeWhile { it.isDigit() }
                input = input.dropWhile { it.isDigit() }

                Token(Token.Type.Int, figure)
            }
            else -> TODO("unimplemented for `$ch'")
        }
    }
}