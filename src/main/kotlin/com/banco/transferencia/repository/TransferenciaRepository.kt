package com.banco.transferencia.repository

import com.banco.transferencia.entity.Transferencia
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface TransferenciaRepository : ReactiveSortingRepository<Transferencia, String> {
    fun findAllByUserAccount(userAccount: String): Flux<Transferencia>
}