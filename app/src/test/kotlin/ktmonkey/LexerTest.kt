package ktmonkey

import kotlin.test.Test
import kotlin.test.*

import ktmonkey.*

class LexerTest {
    @Test fun lexerTest() {
            val lexer = Lexer("=")

            assertEquals(lexer.next(), Token(Token.Type.Assign))
    }
}
