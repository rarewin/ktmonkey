package ktmonkey

import ktmonkey.Token

public class Lexer(input: String) {

    var input = input

    fun next(): Token {

        println("FUGAAA: " + input)

        val s = input.take(1)

        input = input.drop(1)

        if (s == "") {
            return Token(Token.Type.EoF)
        }

        val ch = s.single()

        return when (ch) {
            '=' -> Token(Token.Type.Assign)
            else -> TODO()
        }
    }
}