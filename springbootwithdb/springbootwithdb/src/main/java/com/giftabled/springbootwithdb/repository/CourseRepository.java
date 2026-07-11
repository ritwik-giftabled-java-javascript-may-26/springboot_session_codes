package com.giftabled.springbootwithdb.repository;

import com.giftabled.springbootwithdb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
