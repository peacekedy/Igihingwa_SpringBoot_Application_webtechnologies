package com.seedbank.ingemwe.services;

import com.seedbank.ingemwe.model.Imbuto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ImbutoService {

    Imbuto saveimbuto(Imbuto imbuto, MultipartFile NIDAFile);
    Imbuto updateimbuto(Imbuto imbuto);
    void deleteImbuto(int id);
    List<Imbuto>  ImbutoList();
    Page<Imbuto> getPaginatedImbutos(Pageable pageable);
    Optional<Imbuto> findimbutoById(int id);
    List<Imbuto> searchByName(String searchName);
}

