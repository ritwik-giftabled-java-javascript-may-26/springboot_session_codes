package com.giftabled.studentonetoone.repository;

import com.giftabled.studentonetoone.model.StudentIDCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIDRepository extends JpaRepository<StudentIDCard,Long> {
}
