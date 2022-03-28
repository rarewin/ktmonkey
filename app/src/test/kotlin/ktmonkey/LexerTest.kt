package ktmonkey

import kotlin.test.Test
import kotlin.test.*

import ktmonkey.*

    class LexerTest {
        @Test fun lexerTest() {
            val lexer = Lexer("""=+(){},; let five = 5;
            let ten = 10;

            let add = fn(x, y) {
              x + y;
            };

            let result = add(five, ten);
            !-/*5;
            5 < 10 > 5;

            if (5 < 10) {
              return true;
            } else {
              return false;
            }

            10 == 10;
            10 != 9;

            "foobar"
            "foo bar"

            [1, 2];

            {"foo": "bar"}""")

            val expects = listOf(
                Token.Type.Assign,
                Token.Type.Plus,
                Token.Type.LParen,
                Token.Type.RParen,
                Token.Type.LBrace,
                Token.Type.RBrace,
            )

            for (token in expects) {
                assertEquals(lexer.next(), Token(token))
            }
        }
    }
