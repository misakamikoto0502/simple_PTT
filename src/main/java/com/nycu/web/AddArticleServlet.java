package com.nycu.web;

import com.nycu.pojo.Article;
import com.nycu.pojo.User;
import com.nycu.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addArticleServlet")
public class AddArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String author = user.getUsername();
        System.out.println(session.getAttribute("bid"));
        Integer bid = (Integer) session.getAttribute("bid");
        Integer uid = user.getId();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);
        article.setBid(bid);
        article.setUid(uid);
        article.setAuthor(author);
        articleService.add(article);
        request.setAttribute("add_article_msg","發布成功");
        String href="/selectArticleByBidServlet?id="+bid;
        request.getRequestDispatcher(href).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
