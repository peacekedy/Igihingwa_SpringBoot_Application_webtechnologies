package com.seedbank.ingemwe.services;

import com.seedbank.ingemwe.model.Imbuto;
import com.seedbank.ingemwe.repository.ImbutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ImbutoServiceImp implements ImbutoService {

        @Autowired
        ImbutoRepo repo;


//    @Override
//        public Imbuto saveimbuto(Imbuto imbuto) {
//            return repo.save(imbuto);
//
//        }

    @Override
    public Imbuto saveimbuto(Imbuto imbuto, MultipartFile NIDAFile) {
        if (!NIDAFile.isEmpty()) {
            String contentType = NIDAFile.getContentType();
            if (contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("application/pdf")) {
                try {
                    byte[] NIDA = NIDAFile.getBytes();
                    imbuto.setNIDA(NIDA);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("Only JPEG, PNG, and PDF files are allowed.");
            }
        }
        return repo.save(imbuto);
    }

    @Override
        public Imbuto updateimbuto(Imbuto imbuto) {
            Imbuto savedimbuto = repo.findById(imbuto.getId()).orElse(null);
            if (savedimbuto != null) {
                Imbuto updateimbuto = new Imbuto();

                updateimbuto.setId(savedimbuto.getId());
                updateimbuto.setNames(imbuto.getNames() !=null ? imbuto.getNames() : savedimbuto.getNames());
                updateimbuto.setNIDA(imbuto.getNIDA() !=null ? imbuto.getNIDA(): savedimbuto.getNIDA());
                updateimbuto.setPhone(imbuto.getPhone() !=null ? imbuto.getPhone(): savedimbuto.getPhone());
                updateimbuto.setLand(imbuto.getLand() !=null ? imbuto.getLand(): savedimbuto.getLand());
                updateimbuto.setSize(imbuto.getSize() !=null ? imbuto.getSize(): savedimbuto.getSize());
                updateimbuto.setCrop(imbuto.getCrop() !=null? imbuto.getCrop(): savedimbuto.getCrop());
                updateimbuto.setFertilizers(imbuto.getFertilizers() !=null ? imbuto.getFertilizers(): savedimbuto.getFertilizers());

                return repo.save(updateimbuto);
            }
            return null;
        }

    @Override
    public void deleteImbuto(int id) {
     repo.deleteById(id);
    }

    @Override
    public List<Imbuto> ImbutoList() {
        List<Imbuto> imbutos = repo.findAll();
        return imbutos;
    }

    @Override
    public Optional<Imbuto> findimbutoById(int id) {

        return repo.findById(id);
    }

    public Page<Imbuto> getPaginatedImbutos(Pageable pageable) {
        List<Imbuto> allImbutos = ImbutoList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allImbutos.size());

        return new PageImpl<>(allImbutos.subList(start, end), pageable, allImbutos.size());
    }
    @Override
    public List<Imbuto> searchByName(String searchName) {

        String artistic = searchName;
        List<Imbuto> allArtists = repo.searchByName(artistic);
        return allArtists;

    }
}
