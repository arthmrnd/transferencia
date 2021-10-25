package com.banco.transferencia.service

import com.banco.transferencia.dto.TransferRequest
import com.banco.transferencia.entity.Transferencia
import com.banco.transferencia.repository.TransferenciaRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@Service
class TransferenciaService(
    val transferenciaRepository: TransferenciaRepository
) {

    fun doTransfer(transfer: TransferRequest): String {
        //TODO CONVERT DTO
        var transferencia = convertRequest(transfer)

        //TODO VERIFY BALANCE
        //TODO VERIFY RECEIVER CONTACT
        //TODO DO TRANSFER

        saveTransfer(transferencia)
        return if (transferencia.transferSuccess) {
            "Transferido com sucesso"
        } else "Erro na Transferencia!"
    }

    fun convertRequest(transfer: TransferRequest): Transferencia {
        return Transferencia(
            UUID.randomUUID().toString(),
            transfer.userAccount,
            transfer.receiverContact,
            transfer.value,
            transfer.type,
            LocalDateTime.now(),
            false
        )
    }

    fun saveTransfer(transferencia: Transferencia): Mono<Transferencia> {
        return transferenciaRepository.save(transferencia)
    }
}