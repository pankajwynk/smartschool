package com.school.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.school.dto.Student;
import com.school.repo.StudentRepo;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SchoolController {

  @Autowired StudentRepo studentRepo;

  Student key=new Student();

  LoadingCache<Student, Student> studentCache =
      CacheBuilder.newBuilder()
          .expireAfterAccess(30, TimeUnit.SECONDS).maximumSize(3).recordStats()
          .build(
              new CacheLoader<Student, Student>() {
                @Override
                public Student load(Student student) throws Exception {
                  String name = student.getSname();
                  String section = student.getSection();
                  int standard = student.getStandard();
                  return studentRepo.findBySnameAndSectionAndStandard(name, section, standard);
                }
              });

  @RequestMapping(value = "setstudentdata", method = RequestMethod.POST)
  public Student setstudentdata(@RequestBody Student student) {
    String grade = student.getGrade();
    student.setStandard(Integer.parseInt(grade.replaceAll("[^0-9]", "")));
    student.setSection(grade.replaceAll("[0-9]", "").toUpperCase());
    studentRepo.save(student);
    return student;
  }

  @RequestMapping(value = "getalldata", method = RequestMethod.GET)
  public List<Student> getalldata() {
    return studentRepo.findAll();
  }

  @RequestMapping(value = "getstudentdata", method = RequestMethod.GET)
  public Student getstudentdata(
      @RequestParam("grade") String grade, @RequestParam("name") String name) {
    int standard = Integer.parseInt(grade.replaceAll("[^0-9]", ""));
    String section = grade.replaceAll("[0-9]", "");
    key.setSection(section);
    key.setStandard(standard);
    key.setSname(name);
    System.out.println(studentCache.stats());
    try {
      return studentCache.get(key);
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    return null;
  }
}
