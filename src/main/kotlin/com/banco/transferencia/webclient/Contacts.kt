package com.banco.transferencia.webclient

data class Contacts(
    val id: String,
    val name: String,
    val cpf_cnpj: String,
    val elements: List<Account>
)
