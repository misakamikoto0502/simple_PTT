package com.nycu.web;

import com.nycu.pojo.Board;
import com.nycu.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addBoardServlet")
public class AddBoardServlet extends HttpServlet {
    BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String boardName= request.getParameter("boardName");
        Board board = new Board();
        board.setBoardName(boardName);

        boardService.add(board);
        request.setAttribute("add_board_msg","發布成功");
        String href="/selectAllBoardServlet";
        request.getRequestDispatcher(href).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
