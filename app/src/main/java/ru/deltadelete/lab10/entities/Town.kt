package ru.deltadelete.lab10.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Ignore
import androidx.room.PrimaryKey
import ru.deltadelete.lab10.entities.Country

@Entity(
    tableName = "towns",
    foreignKeys = [ForeignKey(
        entity = Country::class,
        parentColumns = ["country_id"],
        childColumns = ["country_id"],
        onDelete = CASCADE
    )]
)
public data class Town (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "town_id")
    val id  : Int = 0,

    @ColumnInfo(name = "town_name")
    val name: String,

    @ColumnInfo
    val description: String,

    @ColumnInfo(name = "country_id", index = true)
    val countryId: Int
)