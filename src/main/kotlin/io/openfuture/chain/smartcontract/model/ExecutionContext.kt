package io.openfuture.chain.smartcontract.model

class ExecutionContext(
    val amount: Long,
    val issuerAddress: String,
    private val transfers: ArrayList<TransferInfo> = ArrayList()
) {

    fun addTransfer(recipientAddress: String, transferAmount: Long): Boolean {
        return if (getSpentFunds() + transferAmount > amount) {
            false
        } else {
            val transfer = TransferInfo(recipientAddress, transferAmount)
            transfers.add(transfer)
            true
        }
    }

    fun getTransfers(): List<TransferInfo> = transfers

    fun getSpentFunds(): Long = transfers.map { it.amount }.sum()

}

class TransferInfo(
    val recipientAddress: String,
    val amount: Long
)