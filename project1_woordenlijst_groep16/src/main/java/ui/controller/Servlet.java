package ui.controller;

import domain.model.DomainException;
import domain.model.Woord;
import domain.db.Woordenlijst;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    public Woordenlijst woordenlijst = new Woordenlijst();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }

        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overzicht":
                destination = overzicht(request, response);
                break;
            case "add":
                destination = add(request, response);
                break;

            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String inhoud = request.getParameter("WoordInhoud");
        String niveau = request.getParameter("WoordNiveau");
        String errormessage = "";
        try {
            Woord woord = new Woord(inhoud, niveau);
            woordenlijst.voegToe(woord);
        } catch (DomainException e) {
            errormessage += e.getMessage();
            request.setAttribute("error", errormessage);

        }
        if (errormessage.isBlank()) {
            return overzicht(request, response);
        } else {
            return "voegtoe.jsp";
        }
    }


    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("woordenlijst", woordenlijst.getWoorden());
        return "overzicht.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }


}
