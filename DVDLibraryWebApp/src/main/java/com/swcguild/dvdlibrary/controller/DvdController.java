package com.swcguild.dvdlibrary.controller;

import org.joda.time.LocalDate;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DvdController {

    private DvdLibraryDao dao;

    @Inject
    public DvdController(DvdLibraryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/displayDvdList"}, method = RequestMethod.GET)
    public String displayDvdList(Map<String, Object> model) {
        List<Dvd> dList = dao.getAllDvds();
        model.put("dvdList", dList);
        return "displayDvdList";
    }

    @RequestMapping(value = "/displayAddDvdForm", method = RequestMethod.GET)
    public String displayAddDvdForm(Model model) {
        return "addDvdForm";
    }

    @RequestMapping(value = "/addDvd", method = RequestMethod.POST)
    public String addDvd(Model model, HttpServletRequest req, HttpServletResponse res) {

        String title = req.getParameter("dvdTitle");
        String releaseDate = req.getParameter("dvdReleaseDate");
        String mpaaRating = req.getParameter("dvdMpaaRating");
        String director = req.getParameter("dvdDirector");
        String studio = req.getParameter("dvdStudio");
        String note = req.getParameter("dvdNote");

        try {
            Dvd d = new Dvd();
            d.setTitle(title);
            d.setReleaseDate(LocalDate.parse(releaseDate));     // how should i deal with localDates??
            d.setMpaaRating(mpaaRating);
            d.setDirector(director);
            d.setStudio(studio);
            d.setNote(note);

            dao.addDvd(d);
            return "redirect: displayDvdList";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Please enter a valid release date (YYYY-MM-DD)");
            //return "displayAddDvdForm";
            return "addDvdForm";
        }

    }

    @RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
    public String deleteDvd(@RequestParam("dvdId") int id) {
        dao.removeDvd(id);
        return "redirect:displayDvdList";  //go back to browser, have it resubmit request to server for contactList

    }

    @RequestMapping(value = "/updateDvd", method = RequestMethod.POST)
    public String updateDvd(HttpServletRequest req, HttpServletResponse res) {  //redirect to contact List to get udpadted version after editing
        Dvd d = new Dvd();

        d.setDvdId(Integer.parseInt(req.getParameter("dvdId")));
        d.setTitle(req.getParameter("dvdTitle"));
        d.setReleaseDate(LocalDate.parse(req.getParameter("dvdReleaseDate")));
        d.setMpaaRating(req.getParameter("dvdMpaaRating"));
        d.setDirector(req.getParameter("dvdDirector"));
        d.setStudio(req.getParameter("dvdStudio"));
        d.setNote(req.getParameter("dvdNote"));

        dao.updateDvd(d);
        return "redirect:displayDvdList";

    }

    @RequestMapping(value = "/displayEditDvdForm", method = RequestMethod.GET)
    public String displayEditDvdForm(@RequestParam("dvdId") int id, Model model) {
        //model is so that view can display stuff in edit contact form

        Dvd d = dao.getDvdById(id);
        model.addAttribute("dvd", d);
        //forward to view 

        return "editDvdForm";

    }

    @RequestMapping(value = "/searchDvds", method = RequestMethod.POST)
    public String searchDvds(Model model, HttpServletRequest req, HttpServletResponse res) {

        String searchText = req.getParameter("searchText");
        String searchOption = req.getParameter("searchOption");

        if (searchOption.equalsIgnoreCase("title")) {
            List<Dvd> dvds = dao.getByTitle(searchText);
            model.addAttribute("dvdList", dvds);

        }
        if (searchOption.equalsIgnoreCase("mpaaRating")) {
            List<Dvd> dvds = dao.getByRating(searchText);
            model.addAttribute("dvdList", dvds);
        }
        if (searchOption.equalsIgnoreCase("studio")) {
            List<Dvd> dvds = dao.getByStudio(searchText);
            model.addAttribute("dvdList", dvds);
        }

//need to add this functionality, this is not correct
        if (searchOption.equalsIgnoreCase("director")) {
            Map<String, List<Dvd>> dvdMap = dao.getByDirectorGroupByRating(searchText);
            model.addAttribute("dvdList", dvdMap.values());
        }

//        return "redirect: displayDvdList";  thought of having it redirect but I'm going to use a separate JSP
        return "displaySearchResults";
    }

}
