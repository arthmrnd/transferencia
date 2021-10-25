package com.banco.transferencia.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class Transferencia(

    @Id
    @Column("id_transfer")
    val idTransfer: String,
    @Column("user_account")
    val userAccount: String,
    @Column("receiver_contact")
    val receiverContact: String,
    val value: BigDecimal,
    val type: TransferType,
    @Column("date_time")
    val dateTime: LocalDateTime,
    @Column("transfer_success")
    val transferSuccess: Boolean
)