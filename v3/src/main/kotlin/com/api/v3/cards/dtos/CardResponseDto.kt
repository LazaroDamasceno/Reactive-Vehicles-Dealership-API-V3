package com.api.v3.cards.dtos

data class CardResponseDto(
    val type: String,
    val ownerName: String,
    val ownerSsn: String,
    val number: String
)
