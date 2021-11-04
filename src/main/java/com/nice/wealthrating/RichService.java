//package com.nice.wealthrating;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class RichService {
//    @Autowired
//    RichRepository richRepository;
//
//    public List<Rich> getAll() {
//        List richList = new ArrayList();
//        richRepository.findAll().forEach(rich -> richList.add(rich));
//        return richList;
//    }
//
//    public Rich getRichById(String id) {
//        return richRepository.findById(id).get();
//    }
//
//    public void saveOrUpdate(Rich rich) {
//        richRepository.save(rich);
//    }
//
//    public void delete(String id) {
//        richRepository.deleteById(id);
//    }
//}
