package com.sovereign.scoreboardservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Score (
        @Id
        @Column(name = "username", unique = true, nullable = false)
        @NotNull
        @Size(min = 3, max = 32)
        var username: String = "",

        val total: Int = 0
)