package com.example.board.boardRepo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method

@Controller
class BoardController {

    @Autowired
    private lateinit var boardService: BoardService

    @RequestMapping(path = ["/", "index"], method=[RequestMethod.GET, RequestMethod.POST])
    fun index(model: Model): String{

        model.addAttribute("title", "게시판")
        model.addAttribute("boards", boardService.getAllBoard())
        return "index"
    }

    /**
     * 게시물을 저장
     */
    @GetMapping("/board/save")
    fun saveBoardPage(model: Model): String {

        val page: String = "save"
        val title: String = "게시물 등록"
        model.addAttribute("title", title)

        return page
    }

    /**
     * 게시물을 수정하여 저장
     */
    @GetMapping("/board/update/{boardIdx}")
    fun updateBoardPage(model: Model, @PathVariable boardIdx: Long?): String{
        val page = "save"
        val title = "게시물 수정"
        val board = boardService.getBoard(boardIdx)
        model.addAttribute("board", board)
        model.addAttribute("isUpdate", true)
        model.addAttribute("title", title)

        return page
    }

    /**
     * 게시물 저장
     * index 페이지로 매핑된 컨트롤러를 호출
     */
    @PostMapping("/board/saveBoard")
    fun saveBoard(model: Model,
                  board: Board) : String {
        try{
            val saveBoard = boardService.saveBoard(board)
        } catch(e: Exception){
            e.printStackTrace()
        }

        return "redirect:/index"
    }

    /**
     * 게시물 삭제
     * index 페이지로 매핑된 컨트롤러를 호출
     */
    @PostMapping("/board/deleteBoard")
    fun deleteBoard(model: Model,
                  board: Board) : String {
        try{
            boardService.deleteBoard(board)
        } catch(e: Exception){
            e.printStackTrace()
        }

        return "redirect:/index"
    }
}