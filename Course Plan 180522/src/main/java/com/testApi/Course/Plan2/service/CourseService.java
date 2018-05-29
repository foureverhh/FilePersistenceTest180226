package com.testApi.Course.Plan2.service;

import com.testApi.Course.Plan2.model.Course;
import com.testApi.Course.Plan2.model.Student;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService{

    private StudentService studentService = new StudentService();


     private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("c1","java","monday","teacher1","classroom1",studentService.getStudentsJava()),
            new Course("c2","c","tuesday","teacher2","classroom2",studentService.getStudentsC()),
            new Course("c3","c++","wednesday","teacher3","classroom3",studentService.getStudentsCPlus())
    ));

    /* public List<Course> getCourses(){
         return courses;
     }*/

     public Course getCourseByCourseId(String courseId) throws IOException {

         System.out.println("getCourseByCourseID");
         Course c = new Course();
         for(Course course : courses){
             if(course.getId().equals(courseId))
                 c = course;
         }
         //Save the course
           // saveOneCourse(c);
         return c;
     }
     //To check how many courses a student have chosen
     public List<Course> getCourseByStudentId (String studentId){

         System.out.println("getCourseByStudentID");
         if(studentId.equals("")){
             return courses;
         }

         List<Course> cs = new ArrayList<>();
         for(Course course : courses){
             for(Student student : course.getStudents())
                if(student.getId().contains(studentId))
                    cs.add(course);
         }

         return cs;
     }

     public List<Course> getCourseByCourseAndStudentId(String courseId,String studentId){
         System.out.println("getCourseByCourseIdAndStudentId");
         if(courseId.equals(""))
             return courses;
         else {
             List<Course> cs = new ArrayList<>();
             if(studentId.equals("")){
                 for(Course course : courses)
                     if(course.getId().equals(courseId))
                         cs.add(course);

             }else{
                 for(Course course : courses)
                     for(Student student : course.getStudents())
                         if(course.getId().equals(courseId) && student.getId().equals(studentId))
                             cs.add(course);
             }
             return cs;
         }
     }

    public void addCourse(Course course) {
         courses.add(course);
    }

    public void updateCourse(String courseId,Course course) {
         for(int i=0;i<courses.size();i++){
            if (courses.get(i).getId().equals(courseId))
                courses.set(i,course);
         }
    }

    public void removeCourse(String courseId) {
         for(Course c : courses){
             if(c.getId().equals(courseId))
                 courses.remove(c);
         }
    }

    public void saveOneCourse(Course course) throws IOException {
        File file = new File("CourseSelected.txt");
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fo);
        output.writeObject(course);

        output.close();
        fo.close();
       /* FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Course.txt",true);
            fileWriter.write("test");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

}
