package io.openfuture.chain.smartcontract.model

import java.io.Serializable

abstract class SmartContract : Serializable {

    val owner: String = ""
    val address: String = ""

    private var executionContext: ExecutionContext? = null


    abstract fun execute()

    protected fun transfer(recipientAddress: String, amount: Long): Boolean {
        return executionContext!!.addTransfer(recipientAddress, amount)
    }

    protected fun getAmount(): Long = executionContext!!.amount

    protected fun getIssuerAddress(): String = executionContext!!.issuerAddress

}
