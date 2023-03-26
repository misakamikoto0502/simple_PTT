package com.nycu.web;

import com.nycu.pojo.Article;
import com.nycu.pojo.Comment;
import com.nycu.pojo.User;
import com.nycu.service.ArticleService;
import com.nycu.service.CommentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/showArticleServlet")
public class ShowArticleServlet extends HttpServlet {
    private CommentService commentService = new CommentService();
    private ArticleService articleService = new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("id");
        Article article = articleService.selectById(Integer.parseInt(aid));
        List<Comment> comments = commentService.selectByAid(Integer.parseInt(aid));
        request.setAttribute("comments",comments);
        request.setAttribute("article",article);
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println(user.isAdmin());
        request.setAttribute("isAdmin",user.isAdmin());
        request.getRequestDispatcher("/article.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
