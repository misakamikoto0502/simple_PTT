package com.nycu.web;

import com.nycu.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/deleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        String aid = request.getParameter("aid");
        articleService.deleteById(Integer.parseInt(aid));
        request.setAttribute("del_article_msg","刪除成功");
        String href="/selectArticleByBidServlet?id="+bid;
        request.getRequestDispatcher(href).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
