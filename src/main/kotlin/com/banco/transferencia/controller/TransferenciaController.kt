package com.banco.transferencia.controller

import com.banco.transferencia.dto.TransferDTO
import com.banco.transferencia.entity.TransferType
import com.banco.transferencia.entity.Transferencia
import com.banco.transferencia.service.TransferenciaService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/transferencia")
class TransferenciaController(
    val transferenciaService: TransferenciaService
) {
    @PostMapping
    fun enviarTransferencia(@RequestBody transfer: TransferDTO): String {
        return transferenciaService.doTransfer(convertRequest(transfer))
    }

    fun convertRequest(transfer: TransferDTO): Transferencia {
        return Transferencia(
            UUID.randomUUID().toString(),
            transfer.userAccount,
            transfer.userAgency,
            transfer.receiverContact,
            transfer.value,
            transfer.type,
            LocalDateTime.now(),
            false
        )
    }

    @GetMapping
    fun teste(): Flux<Transferencia> {
        //val transfer = convertRequest(TransferDTO("86798","89325","32423", BigDecimal.TEN,TransferType.DOC))
        return transferenciaService.testListAll()
    }
}