package io.openfuture.chain.smartcontract.component.abi

import io.openfuture.chain.smartcontract.model.Abi
import org.objectweb.asm.ClassReader

object AbiGenerator {

    fun generate(bytes: ByteArray): String {
        val reader = ClassReader(bytes)

        val visitor = AbiVisitor()
        reader.accept(visitor, ClassReader.SKIP_DEBUG)

        return Abi.getJson(visitor.abi)
    }

}