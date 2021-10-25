package com.banco.transferencia.repository

import com.banco.transferencia.entity.Transferencia
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface TransferenciaRepository : R2dbcRepository<Transferencia, String>