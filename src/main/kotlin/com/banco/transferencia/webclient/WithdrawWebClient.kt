package com.banco.transferencia.webclient

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.math.BigDecimal

@Component
class WithdrawWebClient {

    val webClient: WebClient = WebClient.create("http://apimuitotopqueadupladesaldofez/withdraw")

    fun doWithdraw(value: BigDecimal): WithdrawResponse? {
        val withdraw = Withdraw(value.toDouble())
        return webClient.post()
            .body(Mono.just(withdraw), Withdraw::class.java)
            .retrieve()
            .bodyToMono(WithdrawResponse::class.java).block()
    }

    fun sendStatus(response: WithdrawResponse): Mono<WithdrawStatus> {
        val id = response.id
        val status = WithdrawStatus("SUCCESS")
        return webClient.put()
            .uri(id)
            .body(Mono.just(status), WithdrawStatus::class.java)
            .retrieve()
            .bodyToMono(WithdrawStatus::class.java)
    }
}