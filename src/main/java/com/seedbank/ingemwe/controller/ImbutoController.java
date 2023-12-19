package com.seedbank.ingemwe.controller;

import com.seedbank.ingemwe.model.Imbuto;
import com.seedbank.ingemwe.services.ImbutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
    public class ImbutoController {

        @Autowired
        private ImbutoService imbutoservice;


        @PostMapping(value = "/imbuto/save")
        public String saveimbuto(@ModelAttribute Imbuto imbuto, @RequestParam("NIDAFile") MultipartFile NIDAFile) {
             if (!NIDAFile.isEmpty()) {
                try {
                    byte[] NIDA = NIDAFile.getBytes();
                    imbuto.setFileName(NIDAFile.getOriginalFilename());
                    imbuto.setNIDA(NIDA);
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    String currentPrincipalName = authentication.getName();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Imbuto newImbuto = imbutoservice.saveimbuto(imbuto, NIDAFile );
            return "redirect:/registration";

        }


        @PostMapping("/imbuto/update/{id}")
        public String updateimbuto(@ModelAttribute Imbuto imbuto) {

           Imbuto newimbuto = imbutoservice.updateimbuto(imbuto);
            return "redirect:/";
        }

//        @GetMapping("/imbuto/delete/{id}")
//        public String deleteimbuto(@PathVariable int id) {
//            imbutoservice.deleteimbuto(id);
//            return "redirect:/";
//        }
//
//        @GetMapping("/imbuto/allimbuto")
//        public String viewAllimbuto(Model model){
//            model.addAttribute("allimbuto", imbutoservice.ImbutoList());
//            return "redirect:/";
//        }



    }

