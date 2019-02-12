package io.openfuture.chain.smartcontract.component.validation

import org.objectweb.asm.ClassReader
import org.slf4j.LoggerFactory

object SmartContractValidator {

    private val log = LoggerFactory.getLogger(SmartContractValidator::class.java)


    fun validate(bytes: ByteArray): Boolean {
        val reader: ClassReader
        try {
            reader = ClassReader(bytes)
        } catch (e: Exception) {
            log.warn("Bytes does not match with bytecode")
            return false
        }

        val visitor = SmartContractVisitor()
        reader.accept(visitor, ClassReader.SKIP_DEBUG)

        val result = visitor.validationResult
        if (result.hasErrors()) {
            log.warn(result.getErrors().joinToString("\n\n"))
            return false
        }

        return true
    }

}