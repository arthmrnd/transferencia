package com.banco.transferencia.dto

import com.banco.transferencia.entity.TransferType
import java.math.BigDecimal

data class TransferDTO(
    val userAccount: String,
    val userAgency: String,
    val receiverContact: String,
    val value: BigDecimal,
    val type: TransferType
)