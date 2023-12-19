package com.seedbank.ingemwe.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="Imbuto")
public class Imbuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Names")
    private String names;

    @Transient
    private MultipartFile NIDAFile;
    @Lob
    @Column(name = "NIDA", columnDefinition = "mediumblob")
    private byte[] NIDA;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "land")
    private String land;
    @Column(name = "size")
    private String size;
    @Column(name = "crop")
    private String crop;
    @Column(name = "fertilizers")
    private String fertilizers;

    public Imbuto() {

    }

    public Imbuto(String names, MultipartFile NIDAFile, byte[] NIDA, String fileName, String phone, String land, String size, String crop, String fertilizers) {
        this.names = names;
        this.NIDAFile = NIDAFile;
        this.NIDA = NIDA;
        this.fileName = fileName;
        this.phone = phone;
        this.land = land;
        this.size = size;
        this.crop = crop;
        this.fertilizers = fertilizers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public MultipartFile getNIDAFile() {
        return NIDAFile;
    }

    public void setNIDAFile(MultipartFile NIDAFile) {
        this.NIDAFile = NIDAFile;
    }

    public byte[] getNIDA() {
        return NIDA;
    }

    public void setNIDA(byte[] NIDA) {
        this.NIDA = NIDA;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(String fertilizers) {
        this.fertilizers = fertilizers;
    }
}