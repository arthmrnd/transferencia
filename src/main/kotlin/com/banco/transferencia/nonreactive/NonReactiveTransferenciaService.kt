package com.banco.transferencia.nonreactive

import com.banco.transferencia.entity.Transferencia
import org.springframework.stereotype.Service

@Service
class NonReactiveTransferenciaService(
    val repository: NonReactiveTransferenciaRepository
) {
    //TODO GET RIDE OF THIS WORKAROUND
    fun checkSimilarTransactions(transferencia: Transferencia): Boolean {
        val transactionsList = repository.findAllByReceiverAccount(transferencia.receiverAccount)

        for (t in transactionsList) {
            if(transferencia.value == t.value &&
                transferencia.dateTime.minusMinutes(5L).isBefore(t.dateTime)) return true
        }
        return false
    }
}
