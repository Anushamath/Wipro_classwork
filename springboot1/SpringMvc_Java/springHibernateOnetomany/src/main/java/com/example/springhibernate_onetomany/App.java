package com.example.springhibernate_onetomany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Springmanytomany.service.StudentService;
import com.example.springhibernate_onetomany.config.AppConfig;
import com.example.springhibernate_onetomany.entity.Courses;
import com.example.springhibernate_onetomany.entity.ReportCard;
import com.example.springhibernate_onetomany.entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
	    
        StudentService service =  ctx.getBean(StudentService.class);
        Student student = new Student("jiya");
        student.addCourse(new Courses("java"));
        student.addCourse(new Courses("servlet"));
        
        ReportCard rc = new ReportCard(490);
      
         student.setReportcard(rc);
         service.saveData(student);
       
         
       
    }
}
