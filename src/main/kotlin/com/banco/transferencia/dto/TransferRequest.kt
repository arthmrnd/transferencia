package com.banco.transferencia.dto

import com.banco.transferencia.entity.TransferType
import java.math.BigDecimal

data class TransferRequest(
    val userAccount: String,
    val receiverContact: String,
    val value: BigDecimal,
    val type: TransferType
)