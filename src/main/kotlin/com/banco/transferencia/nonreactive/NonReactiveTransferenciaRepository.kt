package com.banco.transferencia.nonreactive

import com.banco.transferencia.entity.Transferencia
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NonReactiveTransferenciaRepository : MongoRepository<Transferencia, String> {

    fun findAllByReceiverAccount(receiverAccount: String): List<Transferencia>
}
