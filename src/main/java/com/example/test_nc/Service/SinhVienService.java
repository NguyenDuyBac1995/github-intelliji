package com.example.test_nc.Service;

import com.example.test_nc.Entity.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SinhVienService {

    private List<SinhVien> sinhViens = new ArrayList<>();

    public void addSinhVien(SinhVien sinhVien) {
        if( sinhVien.getName() == null || sinhVien.getName().trim().isEmpty() ){
            throw new IllegalArgumentException("sinhVien can  not be null");
        }

        sinhViens.add(sinhVien);
    }

    public SinhVien getSinhVienById(long id) {

        for (SinhVien sinhVien : sinhViens) {
            if(sinhVien.getId() == id){
                return sinhVien;
            }
        }

        return null;
    }

    public Optional<SinhVien> getSinhVienByIdV2(long id) {
        return sinhViens.stream().filter(sv -> sv.getId() == id).findFirst();
    }

    public void updateSinhVien(SinhVien sinhVien) {
        if(sinhVien.getName() == null || sinhVien.getName().trim().isEmpty()){
            throw new IllegalArgumentException("sinhVien can not be null");
        }

        for(int i = 0; i < sinhViens.size(); i++) {
            if(sinhViens.get(i).getId() == sinhVien.getId()){
                sinhViens.set(i, sinhVien);
                return;
            }
            else {

                throw new IllegalArgumentException("sinhVien with id " + sinhVien.getId() + " khong ton tai");

            }
        }
    }

    public void updateSinhVienV2(SinhVien sinhVien) {
        if(sinhVien.getName() == null || sinhVien.getName().trim().isEmpty()){
            throw new IllegalArgumentException("sinhVien can not be null");
        }
        Optional<SinhVien> existingSinhVien = getSinhVienByIdV2(sinhVien.getId());
        if(existingSinhVien.isPresent()){
            sinhViens.set(sinhViens.indexOf(existingSinhVien.get()), sinhVien);

        }else {
            throw new IllegalArgumentException("sinhVien with id " + sinhVien.getId() + " khong ton tai");
        }
    }

    public boolean deleteSinhVienById(long id) {
        for (int i = 0; i < sinhViens.size(); i++) {
            if(sinhViens.get(i).getId() == id){
                sinhViens.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean deleteSinhVienByIdV2(long id) {
        return sinhViens.removeIf(sinhVien -> sinhVien.getId() == id);
    }

    public List<SinhVien> getAllSinhVien() {

        return new ArrayList<>(sinhViens);

    }


}
