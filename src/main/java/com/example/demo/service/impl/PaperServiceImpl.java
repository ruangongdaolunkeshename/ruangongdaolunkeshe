package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import com.example.demo.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void newpaper(Student student){
        Student s=studentDAO.search(student.username());
        String oldpaper = studentDAO.getpapername(student.username());
        oldpaper = oldpaper + "|" + student.papername();
        String oldupload = studentDAO.getuploadtime(student.username());
        oldupload = oldupload + "|" + student.uploadtime();
        String oldurl = studentDAO.getpaperurl(student.username());
        oldurl = oldurl + "|" + student.paperurl();
        s.setpapername(oldpaper);
        s.setuploadtime(oldupload);
        s.setpaperurl(oldurl);
        studentDAO.delete(student.username());
        studentDAO.updatepaper(s);
    }

}
