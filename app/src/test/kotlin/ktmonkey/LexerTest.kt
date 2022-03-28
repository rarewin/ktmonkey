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
                Token(Token.Type.Assign, "="),
                Token(Token.Type.Plus, "+"),
                Token(Token.Type.LParen, "("),
                Token(Token.Type.RParen, ")"),
                Token(Token.Type.LBrace, "{"),
                Token(Token.Type.RBrace, "}"),
                Token(Token.Type.Comma, ","),
                Token(Token.Type.Semicolon, ";"),
                Token(Token.Type.Let, "let"),
                Token(Token.Type.Ident, "five"),
                Token(Token.Type.Assign, "="),
                Token(Token.Type.Int, "5"),
            )

            for (token in expects) {
                assertEquals(lexer.next(), token)
            }
        }
    }
