package com.example.test_nc.Service;

import com.example.test_nc.Entity.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

class SinhVienServiceTest {

    private SinhVienService sinhVienService;
    @BeforeEach
    void setUp() {
        sinhVienService = new SinhVienService();
    }

    @Test
    void addSinhVienWithValidSV() {
        SinhVien sinhVien = new SinhVien( 1 , "Alisc" , 20, 9.0);
        sinhVienService.addSinhVien(sinhVien);
        assertEquals(1,sinhVienService.getAllSinhVien().size());
    }

    @Test
    void addSinhVienWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> sinhVienService.addSinhVien(null));
        assertEquals("sinhVien can  not be null", exception.getMessage());
    }

    @Test
    void addSinhVienWithInvalidName122() {
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> sinhVienService.addSinhVien(new SinhVien(1,"",30,9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void addSinhVienWithInvalidAge(){
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> sinhVienService.addSinhVien(new SinhVien(1,"Alisc",10,9.0))
        );
        assertEquals("Age must be greater than 18", exception.getMessage());
    }

    @Test
    void addSinhVienWithInvalidMark(){
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> sinhVienService.addSinhVien(new SinhVien(1,"Alisc",30,11.0))
        );
        assertEquals("Mark must be between 0 and 10", exception.getMessage());
    }


    @Test
    void getSinhVienById() {
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);
        sinhVienService.addSinhVien(sv);
        SinhVien result = sinhVienService.getSinhVienById(1);
        assertEquals(sv,result);
        assertNotNull(result);
        assertEquals("A", result.getName());
        assertEquals(20, result.getAge());
        assertEquals(8.0, result.getMark());
        assertEquals(Optional.of(sv),sinhVienService.getSinhVienByIdV2(1));
    }

    @Test
    void getSinhVienByIdV2() {
        SinhVien result = sinhVienService.getSinhVienById(999);
        assertNull(result);
    }

    @Test
    void getSinhVienByIdWithValidId() {
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);

        sinhVienService.addSinhVien(sv);

        assertNull(sinhVienService.getSinhVienById(10));

        assertEquals(Optional.empty(),sinhVienService.getSinhVienByIdV2(9));
    }

    @Test
    void updateSinhVienWithValidSV() {
        SinhVien sinhVien  = new SinhVien( 1 , "Alisc" , 20, 9.0);
        sinhVienService.addSinhVien(sinhVien);
        sinhVien.setName("bod");
        sinhVien.setAge(19);
        sinhVien.setMark(8.0);
        sinhVienService.updateSinhVien(sinhVien);

        assertEquals("bod",sinhVienService.getSinhVienById(1).getName());
        assertEquals(19,sinhVienService.getSinhVienById(1).getAge());
        assertEquals(8.0,sinhVienService.getSinhVienById(1).getMark());
    }

    @Test
    void updateSinhVienWithNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> sinhVienService.updateSinhVien(null));
        assertEquals("sinhVien can not be null", exception.getMessage());
    }

    @Test
    void updateSinhVienWithInvalidId(){
        SinhVien sinhVien = new SinhVien( 1 , "Alisc" , 20, 9.0);
        sinhVienService.addSinhVien(sinhVien);

        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> sinhVienService.updateSinhVien(new SinhVien(2,"Bod",21,8.0))
                ) ;
        assertEquals("sinhVien with id 2 khong ton tai", exception.getMessage());
    }

    @Test
    void updateSinhVienWithInvalidName(){
        SinhVien sinhVien = new SinhVien( 1 , "Alisc" , 20, 9.0);
        sinhVienService.addSinhVien(sinhVien);

        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> sinhVienService.updateSinhVien(new SinhVien(1,"",21,8.0))
        ) ;
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void updateSinhVienWithInvalidAge(){
        SinhVien sinhVien = new SinhVien( 1 , "Alisc" , 20, 9.0);
        sinhVienService.addSinhVien(sinhVien);

        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> sinhVienService.updateSinhVien(new SinhVien(1,"Bod",12,8.0))
        ) ;
        assertEquals("Age must be greater than 18", exception.getMessage());
    }


    @Test
    void updateSinhVienV2() {
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);
        sinhVienService.addSinhVien(sv);
        SinhVien updated = new SinhVien(1, "B", 21, 9.0);
        sinhVienService.updateSinhVien(updated);
        SinhVien result = sinhVienService.getSinhVienById(1);
        assertEquals("B", result.getName());
        assertEquals(21, result.getAge());
        assertEquals(9.0, result.getMark());
    }

    @Test
    void deleteSinhVienWithValidId() {
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);
        sinhVienService.addSinhVien(sv);
        sinhVienService.deleteSinhVienById(1);
        assertEquals(0, sinhVienService.getAllSinhVien().size());
        assertNull(sinhVienService.getSinhVienById(1));
    }

    @Test
    void deleteSinhVienWithInvalidId(){
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);

        sinhVienService.addSinhVien(sv);

        assertFalse(sinhVienService.deleteSinhVienById(10));

    }

    @Test
    void deleteSinhVienByIdV2() {
        sinhVienService.deleteSinhVienById(999);
        assertEquals(0, sinhVienService.getAllSinhVien().size());
    }

    @Test
    void deleteSinhVienById_MultipleTimes() {
        SinhVien sv = new SinhVien(1, "A", 20, 8.0);
        sinhVienService.addSinhVien(sv);
        sinhVienService.deleteSinhVienById(1);
        // Xóa lại lần nữa, không nên ném exception
        sinhVienService.deleteSinhVienById(1);
        assertNull(sinhVienService.getSinhVienById(1));
    }

    @Test
    void deleteSinhVienById_EmptyList() {
        sinhVienService.deleteSinhVienById(1);
        assertEquals(0, sinhVienService.getAllSinhVien().size());
    }

    @Test
    void deleteMultipleSinhVien() {
        SinhVien sv1 = new SinhVien(1, "A", 20, 8.0);
        SinhVien sv2 = new SinhVien(2, "B", 21, 7.5);
        sinhVienService.addSinhVien(sv1);
        sinhVienService.addSinhVien(sv2);
        sinhVienService.deleteSinhVienById(1);
        assertNull(sinhVienService.getSinhVienById(1));
        assertNotNull(sinhVienService.getSinhVienById(2));
        sinhVienService.deleteSinhVienById(2);
        assertNull(sinhVienService.getSinhVienById(2));
        assertEquals(0, sinhVienService.getAllSinhVien().size());
    }

    @Test
    void getAllSinhVien() {
        SinhVien sv1 = new SinhVien(1, "A", 20, 8.0);
        SinhVien sv2 = new SinhVien(2, "B", 21, 7.5);
        sinhVienService.addSinhVien(sv1);
        sinhVienService.addSinhVien(sv2);
        List<SinhVien> all = sinhVienService.getAllSinhVien();
        assertEquals(2, all.size());
    }


}