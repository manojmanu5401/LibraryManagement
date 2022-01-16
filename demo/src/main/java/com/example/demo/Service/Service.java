package com.example.demo.Service;

import com.example.demo.Models.Books;
import com.example.demo.Models.Student;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    private List<Books> books = new ArrayList<>(Arrays.asList(
            Books.builder().bookName("Engineering Physics").bookId("PS001").author("Malik and Singh").build(),
            Books.builder().bookName("Quantum Mechanics").bookId("QM023").author("Raghavan").build(),
            Books.builder().bookName("Fundamentals of Electromagnetic Theory").bookId("SDE05").author("K.K. Aggarwal & Yogesh Singh").build(),
            Books.builder().bookName("Computer Networks").bookId("CN201").author("Deo and Narsingh").build(),
            Books.builder().bookName("Signals And Systems").bookId("SS021").author("Gupta").build(),
            Books.builder().bookName("Robotics Technology").bookId("RT131").author("Wiley").build()
    ));
    private List<Student> students = new ArrayList<>();

    public List<Books> getAllBooks(){
        return books;
    }

    public String addNewBook(Books book) {
        books.add(book);
        return book.getBookName() + " has been added";
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public String addNewStudentToBorrowNewBook(Student student) {
        System.out.println(student);
        students.add(student);
        return "done";
    }

    public String deliveringBookBackToLibrary(int roll, String bookId) {
        for(Student s: students){
//            System.out.println(s.getRollNumber());
            if(s.getRollNumber() == roll){
                s.getBooks().stream()
                        .filter(b->b.getBookId().equalsIgnoreCase(bookId))
                        .findFirst()
                        .map(p->{
                            s.getBooks().remove(p);
                            return "Done";
                        });
            }else{
                return "Roll Number not found";
            }
        }
        return null;
    }

    public Books getBookByBookId(String bookId) {
        return books.stream()
                .filter(b->b.getBookId().equalsIgnoreCase(bookId))
                .findAny()
                .orElse(null);
    }

    public Student getStudentByRollNumber(int roll) {
        return students.stream()
                .filter(s->s.getRollNumber()==roll)
                .findAny()
                .orElse(null);
    }

//    private List<Subject> subjects= new ArrayList<>(Arrays.asList(new Subject("WT",101),
//            new Subject("CN",102),
//            new Subject("DS",103),
//            new Subject("OS",104)));
//    public List<Subject> getSubjectsFCntrl()
//    {
//        return subjects;
//    }
//
//    public Subject getParticularSubject(String sub)
//    {
//        return subjects.stream().filter(t->t.getSubject().equals(sub)).findAny().get();
//    }
//
//    public String addSubject(Subject subject)
//    {
//        subjects.add(subject);
//        return "Subject Added";
//    }
//
//    public void updateSubject(Subject subject,String code) {
//        for (int i = 0; i < subjects.size(); i++)
//        {
//            Subject s=subjects.get(i);
//            if(s.getSubject().equals(code)) {
//                subjects.set(i, subject);
//                return;
//            }
//        }
//    }
//
//    public void deleteSubject(String code)
//    {
//        subjects.removeIf(t->t.getSubject().equals(code));
//    }
}
