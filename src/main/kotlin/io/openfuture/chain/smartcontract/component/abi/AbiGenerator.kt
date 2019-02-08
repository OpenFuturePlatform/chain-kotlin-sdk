package io.openfuture.chain.smartcontract.component.abi

import io.openfuture.chain.smartcontract.exception.ByteCodeException
import io.openfuture.chain.smartcontract.model.Abi
import org.objectweb.asm.ClassReader

object AbiGenerator {

    fun generate(bytes: ByteArray): String {
        val reader = try {
            ClassReader(bytes)
        } catch (e: Exception) {
            throw ByteCodeException("Bytes does not match with bytecode")
        }

        val visitor = AbiVisitor()
        reader.accept(visitor, ClassReader.SKIP_DEBUG)

        return Abi.getJson(visitor.abi)
    }

}