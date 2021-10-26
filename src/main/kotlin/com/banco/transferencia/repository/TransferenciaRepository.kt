package com.banco.transferencia.repository

import com.banco.transferencia.entity.Transferencia
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TransferenciaRepository : ReactiveSortingRepository<Transferencia, String>