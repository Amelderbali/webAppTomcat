package org.example.demo.servlets;

import org.example.demo.data.Annonce;
import org.example.demo.data.AnnonceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/detailAnnonce")
public class DetailAnnonceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id"); // Get the ad ID

        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ad ID is missing.");
            return;
        }

        int id = Integer.parseInt(idParam);
        AnnonceDAO annonceDAO = new AnnonceDAO();

        try {
            Annonce annonce = annonceDAO.getAnnonceById(id);
            if (annonce == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ad not found.");
                return;
            }

            request.setAttribute("annonce", annonce);

            request.getRequestDispatcher("detailAnnonce.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error loading ad.");
        }
    }
}
