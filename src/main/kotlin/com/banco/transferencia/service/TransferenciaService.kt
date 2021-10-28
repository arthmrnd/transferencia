package com.banco.transferencia.service

import com.banco.transferencia.entity.Transferencia
import com.banco.transferencia.nonreactive.NonReactiveTransferenciaService
import com.banco.transferencia.repository.TransferenciaRepository
import com.banco.transferencia.webclient.ContactWebClient
import com.banco.transferencia.webclient.WithdrawResponse
import com.banco.transferencia.webclient.WithdrawWebClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TransferenciaService(
    val repository: TransferenciaRepository,
    val withdrawWebClient: WithdrawWebClient,
    val contactWebClient: ContactWebClient,
    val nonReactiveTransferenciaService: NonReactiveTransferenciaService
) {

    fun doTransfer(transferencia: Transferencia): Mono<Transferencia> {

        if (nonReactiveTransferenciaService.checkSimilarTransactions(transferencia)){
            return saveTransfer(transferencia)
        }

        val withdrawConsult: WithdrawResponse = withdrawWebClient
            .doWithdraw(transferencia.value) ?: return saveTransfer(transferencia)

        val contactList = contactWebClient.getContacts()
        for (contact in contactList) {
            if (contact.cc == transferencia.receiverAccount
                && contact.ag == transferencia.receiverAgency) {
                    transferencia.transferSuccess = true
            }
        }

        val monoTransferencia = saveTransfer(transferencia)
        if (transferencia.transferSuccess) {
            withdrawWebClient.sendStatus(withdrawConsult)
        }
        return monoTransferencia

    }

    fun listByUser(userAccount: String): Flux<Transferencia> {
        return repository.findAllByUserAccount(userAccount)
    }


    fun saveTransfer(transferencia: Transferencia): Mono<Transferencia> {
        return repository.save(transferencia)
    }


}
