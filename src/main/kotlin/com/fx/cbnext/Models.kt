package com.fx.cbnext

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.util.Date
import javax.persistence.*

data class Info(
        @ApiModelProperty(notes = "flag that CB T+1 rate is available to this client", required = true)
        val available: Boolean,

        @ApiModelProperty(notes = "end of sending time by CB T+1 documents", required = false)
        val time: Date? = null,

        @ApiModelProperty(notes = "var customer settings", required = false)
        val note: String? = null
)

@Entity
@Table(name = "tod_documents")
data class Tod(

        @ApiModelProperty(notes = "doc id")
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @ApiModelProperty(notes = "client name", required = true)
        @Column(name = "client", nullable = false)
        val client: String = "",

        @ApiModelProperty(notes = "ISO code of based currency (?/RUB)", required = true, example = "USD")
        @JsonProperty("baseCurrency")
        @Column(name = "currency", length = 3, nullable = false)
        val currency: String = "USD",

        @ApiModelProperty(notes = "deal amount", required = true, example = "1234.56")
        @JsonProperty("baseCurrencyAmount")
        @Column(name = "amount", nullable = false)
        val amount: BigDecimal = ZERO,

        @ApiModelProperty(notes = "currency rate", required = true, example = "34.1523")
        @Column(name = "rate", nullable = false)
        val rate: BigDecimal = ZERO
)