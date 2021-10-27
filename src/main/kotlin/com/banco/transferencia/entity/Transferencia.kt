package com.banco.transferencia.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Document
data class Transferencia(

    @Id
    val idTransfer: String,
    val userAccount: String,
    val userAgency: String,
    val receiverAccount: String,
    val receiverAgency: String,
    val value: BigDecimal,
    val type: TransferType,
    val dateTime: LocalDateTime,
    var transferSuccess: Boolean
)