package com.banco.transferencia.service

import com.banco.transferencia.entity.Transferencia
import com.banco.transferencia.repository.TransferenciaRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TransferenciaService(
    val transferenciaRepository: TransferenciaRepository
) {

    fun doTransfer(transferencia: Transferencia): String {

        //TODO ADD COROUTINE TO VERIFY THE TRANSFER TIME
        //TODO VERIFY BALANCE
        //TODO VERIFY RECEIVER CONTACT
        //TODO DO TRANSFER

        saveTransfer(transferencia)
        transferencia.transferSuccess = true
        return if (transferencia.transferSuccess) {
            "Transferido com sucesso"
            //TODO SEND CONFIRMATION TO SALDO MICROSERVICE
        } else "Erro na Transferencia!"

    }

    fun testListAll(): Flux<Transferencia> {
        return transferenciaRepository.findAll()
    }


    fun saveTransfer(transferencia: Transferencia): Mono<Transferencia> {
        return transferenciaRepository.save(transferencia)
    }


}