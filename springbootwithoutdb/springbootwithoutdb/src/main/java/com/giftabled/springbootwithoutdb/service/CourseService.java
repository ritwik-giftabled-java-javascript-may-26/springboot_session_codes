package com.giftabled.springbootwithoutdb.service;

import com.giftabled.springbootwithoutdb.model.Course;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public List<Course> getAllCourses(){
        return courseList;
    }

    public Course addCourse(Course course){
        courseList.add(course);
        return course;
    }

    public Course getCourseById(Long courseId ){
        for (Course course : courseList) {
            if(course.getId() == courseId){
                return course;
            }
        }
        return null;
    }

    public Course updateCourse(Long courseId,Course course){
        for (Course courseIterator : courseList){
            if(courseIterator.getId() == courseId){
                courseIterator.setTitle(course.getTitle());
                courseIterator.setDescription(course.getDescription());
            }
        }
        return course;
    }

    public void deleteCourseById(Long courseId){
        courseList = courseList
                .stream()
                .filter(e-> e.getId() != courseId)
                .collect(Collectors.toList());
    }

    public List<Course> addMultipleCourses(List<Course> courseLists) {
        courseList.addAll(courseLists);
        return courseList;
    }

    public Boolean deleteCourse(Long courseId){
        for (Course course : courseList){
            if(course.getId() == courseId){
                courseList.remove(course);
                return true;
            }
        }
        return false;
    }
}
