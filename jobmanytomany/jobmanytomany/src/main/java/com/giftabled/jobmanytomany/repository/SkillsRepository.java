package com.giftabled.jobmanytomany.repository;

import com.giftabled.jobmanytomany.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skill,Long> {
}
