package com.nycu.web;

import com.nycu.mapper.CommentMapper;
import com.nycu.pojo.Article;
import com.nycu.pojo.Comment;
import com.nycu.pojo.User;
import com.nycu.service.CommentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/addCommentServlet")
public class AddCommentServlet extends HttpServlet {
    CommentService commentService = new CommentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String aid=request.getParameter("aid");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String author = user.getUsername();
        Integer uid = user.getId();
        String content = request.getParameter("content");
        Comment comment = new Comment();
        comment.setAid(Integer.valueOf(aid));
        comment.setAuthor(author);
        comment.setUid(uid);
        comment.setContent(content);
        commentService.add(comment);
        request.setAttribute("add_comment_msg","發布成功");
        String href="/showArticleServlet?id="+aid;
        request.getRequestDispatcher(href).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
