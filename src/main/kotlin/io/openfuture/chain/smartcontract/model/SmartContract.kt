package io.openfuture.chain.smartcontract.model

import java.io.Serializable

abstract class SmartContract : Serializable {

    val owner: String = ""
    val address: String = ""


    abstract fun execute()

}
