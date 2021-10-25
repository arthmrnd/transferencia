package com.banco.transferencia.controller

import com.banco.transferencia.dto.TransferRequest
import com.banco.transferencia.service.TransferenciaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transferencia")
class TransferenciaController(
    val transferenciaService: TransferenciaService
) {
    @PostMapping
    fun enviarTransferencia(@RequestBody transfer: TransferRequest): String {
        return transferenciaService.doTransfer(transfer)
    }
}