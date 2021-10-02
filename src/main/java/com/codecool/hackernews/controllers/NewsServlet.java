package com.codecool.hackernews.controllers;

import com.codecool.hackernews.Layout;
import com.codecool.hackernews.dao.NewsDao;
import com.codecool.hackernews.dao.NewsDaoFromApi;
import com.codecool.hackernews.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "newsServlet", urlPatterns = {"/news"})
public class NewsServlet extends HttpServlet {


    public static final String NEWS_ENDPOINT = "news";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        NewsDao newsDao = new NewsDaoFromApi();
        try {
            int page = readPage(req);

            List<News> newsList = newsDao.read(NEWS_ENDPOINT, page);
            Layout layout = new Layout();

            String header = layout.getHeader();
            String footer = layout.getFooter();

            out.println(header);

            StringBuilder content = new StringBuilder();
            content.append("<ul>");
            for (News news : newsList) {
                content.append("<li>");
                content.append("<a href=\"" + news.getUrl() + "\">");
                content.append(news.getTitle() + ", posted by " + news.getAuthor() + " " + news.getTimeAgo());
                content.append("</a>");
                content.append("</li>");
            }

            content.append("</ul>");
            out.println(content);

            out.println("<div>" +
                    "<button id='prev'>Prev</button>" +
                    "<button id='next'>Next</button>" +
                    "</div>");

            out.println(footer);


        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Page should be positive number");
        }
    }

    private int readPage(HttpServletRequest req) {
        String pageString = req.getParameter("page");
        if (pageString == null) {
            return 1;
        }
        int page = Integer.parseInt(pageString);
        if (page < 1)
            throw new NumberFormatException("Page should be positive");

        return page;

    }
}
