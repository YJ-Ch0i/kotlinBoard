package com.example.board.boardRepo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BoardService {

    @Autowired
    lateinit var boardRepository: BoardRepository

    @Transactional
    fun saveBoard(board: Board): Board{
        return boardRepository.save(board)
    }

    fun getAllBoard() : List<Board>{
        return boardRepository.findAll()
    }

    fun getBoard(boardIdx: Long?): Board{
        return boardRepository.findByBoardIdx(boardIdx)
    }

    fun deleteBoard(board: Board){
        boardRepository.delete(board)
    }
}