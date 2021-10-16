package com.example.board.boardRepo

import org.springframework.format.annotation.DateTimeFormat
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val boardIdx: Long? = null,
    val boardSubject: String,
    val boardContent: String,
    val regDt: String = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH/mm"))
)
