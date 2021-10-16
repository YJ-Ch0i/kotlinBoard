package com.example.board.boardRepo;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board, String>{

    fun findByBoardIdx(boardIdx: Long?): Board

}