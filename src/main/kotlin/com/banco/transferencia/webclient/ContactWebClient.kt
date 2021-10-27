package com.banco.transferencia.webclient

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class ContactWebClient {

    val webClient = WebClient.create("http://apitopfeitapelaequipedecontatos/contacts")

    fun getContacts(): List<Account> {
        val contacts = webClient.get()
            .retrieve()
            .bodyToMono(Contacts::class.java)
            .block()

        return contacts?.elements ?: (emptyList())
    }
}