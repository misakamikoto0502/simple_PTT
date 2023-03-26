package com.nycu.web;

import com.nycu.pojo.Board;
import com.nycu.pojo.User;
import com.nycu.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllBoardServlet")
public class SelectAllBoardServlet extends HttpServlet {
    private BoardService service = new BoardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Board> boards = service.selectAll();

        //2. 存入request域中
        request.setAttribute("boards",boards);
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println(user.isAdmin());
        request.setAttribute("isAdmin",user.isAdmin());
        System.out.println(user.isAdmin());
        //3. 转发到brand.jsp
        request.getRequestDispatcher("/board.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
