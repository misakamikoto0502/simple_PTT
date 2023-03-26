package com.nycu.web;

import com.nycu.pojo.Article;
import com.nycu.service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectArticleByBidServlet")
public class SelectArticleByBidServlet extends HttpServlet {
    ArticleService articleService = new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("id");
        List<Article> articles = articleService.selectByBid(Integer.parseInt(bid));
        HttpSession session = request.getSession();
        session.setAttribute("bid",Integer.parseInt(bid));
        request.setAttribute("articles",articles);

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/articleList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
