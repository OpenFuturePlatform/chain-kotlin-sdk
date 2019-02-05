package io.openfuture.chain.smartcontract.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Abi(
    val abiMethods: MutableList<AbiMethod> = mutableListOf()
) {

    fun addMethod(methodName: String, argumentTypes: List<String>) {
        abiMethods.add(AbiMethod(methodName, argumentTypes))
    }

    override fun toString(): String {
        return "Abi(abiMethods=$abiMethods)"
    }


    companion object {
        fun getJson(abi: Abi): String = jacksonObjectMapper().writeValueAsString(abi.abiMethods)

        fun fromJson(json: String): Abi = Abi(jacksonObjectMapper().readValue(json))
    }


    data class AbiMethod(
        val name: String,
        val inputs: List<String>
    )

}