package io.openfuture.chain.smartcontract.component.validation

object Whitelist {

    fun isAllowedType(className: String): Boolean {
        if (whiteList.contains(className)) {
            return true
        }

        return false
    }

    private val whiteList = setOf(
        Boolean::class.java.name,
        Char::class.java.name,
        Byte::class.java.name,
        Short::class.java.name,
        Int::class.java.name,
        Long::class.java.name,
        Float::class.java.name,
        Double::class.java.name,
        Void::class.javaPrimitiveType!!.name,

        "java.lang.Boolean",
        "java.lang.Character",
        "java.lang.Byte",
        "java.lang.Short",
        "java.lang.Integer",
        "java.lang.Long",
        "java.lang.Float",
        "java.lang.Double",
        "java.lang.String",
        "java.lang.StringBuilder",
        "java.lang.StrictMath",

        "java.util.ArrayList",
        "java.util.Arrays",
        "java.util.HashMap",
        "java.util.HashSet"
    )

}