package com.api.v3.cards.domain.superclass

import com.api.v3.cards.utils.CardNumberGenerator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Document
open class Card {

    @Id var id: UUID = UUID.randomUUID()
    var type: String
    var ownerName: String
    var ownerSsn: String
    var number: String = CardNumberGenerator.generate()
    var createdAt: LocalDateTime = LocalDateTime.now()
    var createdAtZone: ZoneId = ZoneId.systemDefault()

    protected constructor(type: String, ownerName: String, ownerSsn: String) {
        this.type = type
        this.ownerName = ownerName
        this.ownerSsn = ownerSsn
    }

}