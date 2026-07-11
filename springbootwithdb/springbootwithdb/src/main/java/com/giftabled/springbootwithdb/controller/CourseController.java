package com.giftabled.springbootwithdb.controller;

import com.giftabled.springbootwithdb.model.Course;
import com.giftabled.springbootwithdb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //@RequestMapping(value = "/welcome",method = GET)
    @GetMapping("/welcome")
    public void welcome(){
        System.out.println("Hello world from get method of http");
    }

    @GetMapping()
    public ResponseEntity<List<Course>> getCourses(){
        try {
            return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping()
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        try {
            return new ResponseEntity<>(courseService.addCourse(course),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId){
        try {
            return new ResponseEntity<>(courseService.getCourseById(courseId),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId,@RequestBody Course course){
        try {
            return new ResponseEntity<>(courseService.updateCourse(courseId,course),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long courseId){
       try {
           courseService.deleteCourseById(courseId);
           return new ResponseEntity("deleted successfully by the stream api",HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PostMapping("/multiple-courses")
    public ResponseEntity<List<Course>> addMultipleCourses(@RequestBody List<Course> courseLists){
        try {
            return new ResponseEntity<>(courseService.addMultipleCourses(courseLists),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @DeleteMapping("/for/{courseId}")
//    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
//            Boolean deleted = courseService.deleteCourse(courseId);
//            System.out.println(deleted);
//            if (deleted){
//                return new ResponseEntity<>("deleted successfully by the for loop",HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

}
