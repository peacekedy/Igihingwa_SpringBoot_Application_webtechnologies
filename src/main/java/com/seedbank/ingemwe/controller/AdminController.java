package com.seedbank.ingemwe.controller;


import com.seedbank.ingemwe.model.Imbuto;
import com.seedbank.ingemwe.services.ImbutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    //    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
//    public String adminHome() {
//        return "admin/dashboard";
//}
    @Autowired
    private ImbutoService imbutoservice;


    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 3; // Number of rows to display per page
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Imbuto> artistsPage = imbutoservice.getPaginatedImbutos(pageable);
        List<Imbuto> imbutos = artistsPage.getContent();

        model.addAttribute("allImbutos", imbutos);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", artistsPage.getTotalPages());

        return "admin/dashboard";
    }

    @GetMapping("/admin/dashboard/delete/{id}")
    public String deleteImbuto(@PathVariable int id) {
        imbutoservice.deleteImbuto(id);
        return "/homepage";
    }


    @GetMapping("/imbuto/download/{id}")
    public ResponseEntity<byte[]> downloadPortfolio(@PathVariable("id") int id) {
        Optional<Imbuto> imbuto = imbutoservice.findimbutoById(id);
        if (imbuto != null) {
            Imbuto but = imbuto.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", but.getFileName());

            return new ResponseEntity<>(but.getNIDA(), headers, HttpStatus.OK);

        } else {

            return null;
        }
    }

    @GetMapping("/search")
    public String SearchArtist(@RequestParam("search") String name, Model model) {
        List<Imbuto> plots = imbutoservice.searchByName(name);
        model.addAttribute("listplot", plots);


        return "home";
    }
}