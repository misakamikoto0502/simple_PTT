package com.nycu.web;

import com.nycu.pojo.Article;
import com.nycu.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/toUpdateArticleServlet")
public class ToUpdateArticleServlet extends HttpServlet {
    ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
        Article article=articleService.selectById(Integer.parseInt(aid));
        String title = article.getTitle();
        String content = article.getContent();
        request.setAttribute("title",title);
        request.setAttribute("content",content);
        request.setAttribute("aid",aid);
        request.getRequestDispatcher("/updateArticle.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
