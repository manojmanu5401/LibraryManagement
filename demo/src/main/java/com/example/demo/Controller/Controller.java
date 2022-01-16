package com.example.demo.Controller;
import com.example.demo.Models.Books;
import com.example.demo.Models.Student;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/library")
public class Controller {

    @Autowired
    Service service;

//    ..........................BOOKS......................................
    @GetMapping("/books")
    public List<Books> getBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Books getBook(@PathVariable String bookId){
        return service.getBookByBookId(bookId);
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Books book){
        return service.addNewBook(book);
    }


//    ....................STUDENTS...........................................
    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/students/{roll}")
    public Student getStudent(@PathVariable int roll){
        return service.getStudentByRollNumber(roll);
    }

    @PostMapping("/students")
    public String addStudentToBorrowBook(@RequestBody Student student){
        return service.addNewStudentToBorrowNewBook(student);
    }

    @PutMapping("/students/update/{roll}/{bookId}")
    public String deliveringBook(@PathVariable int roll, @PathVariable String bookId){
        return service.deliveringBookBackToLibrary(roll, bookId);
    }

//    @RequestMapping("StudentName")
//    public String studentName()
//    {
//        return student.getName();
//    }
//
//    @RequestMapping("GetSubjects")
//    public List<Subject> getSubjects()
//    {
//        // SPRING CONVERTS LIST INTO JSON OBJECT
//        return Arrays.asList(new Subject("WT",101),
//                new Subject("CN",102),
//                new Subject("DS",103),
//                new Subject("OS",104));
//    }
//    @Autowired
//    private com.example.demo.Service.Controller controller;
//
//    @RequestMapping("GetSubjectFromController")
//    public List<Subject> getSubjectsFromControllerClass()
//    {
//        return controller.getSubjectsFCntrl();
//    }
//
//    @RequestMapping("GetSubjectFromController/{sbj}")
//    public Subject getParticularSubject(@PathVariable("sbj") String particularSub)
//    {
//        return controller.getParticularSubject(particularSub);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/GetSubjectFromController")
//    public String addSubject(@RequestBody Subject subject)
//    {
//        return controller.addSubject(subject);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/GetSubjectFromController/{sbj}")
//    public void updateSubject(@RequestBody Subject subject, @PathVariable("sbj") String code)
//    {
//        controller.updateSubject(subject,code);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/GetSubjectFromController/{sbj}")
//    public void deleteSubject(@PathVariable("sbj") String code)
//    {
//        controller.deleteSubject(code);
//    }


}
