package com.fara.feature_home_domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbersHistory")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val number: Int,
    val text: String
)
