package com.banco.transferencia.controller

import com.banco.transferencia.dto.TransferDTO
import com.banco.transferencia.entity.Transferencia
import com.banco.transferencia.service.TransferenciaService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/transferencia")
class TransferenciaController(
    val service: TransferenciaService
) {
    @PostMapping
    fun doTransfer(@RequestBody transfer: TransferDTO): Mono<Transferencia> {
        return service.doTransfer(convertRequest(transfer))
    }

    fun convertRequest(transfer: TransferDTO): Transferencia {
        return Transferencia(
            UUID.randomUUID().toString(),
            transfer.userAccount,
            transfer.userAgency,
            transfer.receiverAccount,
            transfer.receiverAgency,
            transfer.value,
            transfer.type,
            LocalDateTime.now(),
            false
        )
    }

    @GetMapping
    fun transactionsByUser(@RequestBody userAccount: String): Flux<Transferencia> {
        return service.listByUser(userAccount)
    }

}