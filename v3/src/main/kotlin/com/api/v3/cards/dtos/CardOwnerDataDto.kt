package com.api.v3.cards.dtos

import jakarta.validation.constraints.NotBlank

data class CardOwnerDataDto(
    var ownerName: @NotBlank String,
    var ownerSsn: @NotBlank String,
)
