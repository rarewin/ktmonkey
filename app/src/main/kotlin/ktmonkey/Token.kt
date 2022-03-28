package ktmonkey

public class Token(type: Type, literal: String) {
    var type = type
    var literal = literal

    enum class Type {
        Illegal,
        EoF,

        Ident,
        Int,

        Assign,
        Plus,
        Minus,
        Bang,
        Asterisk,
        Slash,

        Lt,
        Gt,

        Eq,
        NotEq,

        Comma,
        Semicolon,
        Colon,

        LParen,
        RParen,
        LBrace,
        RBrace,
        LBracket,
        RBracket,

        Function,
        Let,
        True,
        False,
        If,
        Else,
        Return,

        String,
    }

    override fun equals(other: Any?): Boolean {
        if (!(other is Token)) {
            return false
        }
        
        return (this.type == other.type) && (this.literal == other.literal)
    }
}