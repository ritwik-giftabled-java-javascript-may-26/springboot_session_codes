package com.giftabled.springbootwithdb.service;

import com.giftabled.springbootwithdb.model.Course;
import com.giftabled.springbootwithdb.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId ){
        return courseRepository.findById(courseId).get();
    }

    public Course updateCourse(Long courseId,Course course){
        course.setId(courseId);
        return courseRepository.save(course);
    }

    public void deleteCourseById(Long courseId){
        courseRepository.deleteById(courseId);
    }

    public List<Course> addMultipleCourses(List<Course> courseLists) {
        return courseRepository.saveAll(courseLists);
    }

//    public Boolean deleteCourse(Long courseId){
//
//        courseRepository.deleteById(courseId);
//        return false;
//    }
}
