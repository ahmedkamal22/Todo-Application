package com.kamal.todoapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @ColumnInfo @PrimaryKey(autoGenerate = true) val id:String?=null,
    @ColumnInfo val title:String?=null,
    @ColumnInfo val description:String?=null,
    @ColumnInfo val isCompeleted:Boolean=false
)