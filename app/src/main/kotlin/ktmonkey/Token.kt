package ktmonkey

public class Token(type: Type) {
    var type = type

    enum class Type {
        Illegal,
        EoF,

        Ident,
        Int,

        Assign,
        Plus,
    }

    override fun equals(other: Any?): Boolean {
        if (!(other is Token)) {
            return false
        }
        
        return (this.type == other.type)
    }
}