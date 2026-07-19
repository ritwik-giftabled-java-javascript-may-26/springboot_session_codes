package com.giftabled.jobmanytomany.service;

import com.giftabled.jobmanytomany.model.Job;
import com.giftabled.jobmanytomany.model.Skill;
import com.giftabled.jobmanytomany.repository.JobRepository;
import com.giftabled.jobmanytomany.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    public Job saveJob(Job job){
        return jobRepository.save(job);
    }

    public Skill saveSkill(Skill skill){
        return skillsRepository.save(skill);
    }

    public Job addSkillToJobId(Long jobId,Long skillId){

        Optional<Job> jobOpt = jobRepository.findById(jobId);
        Optional<Skill> skillOpt = skillsRepository.findById(skillId);

        if(jobOpt.isPresent() && skillOpt.isPresent()) {

            Job job = jobOpt.get();
            Skill skill = skillOpt.get();

            job.getSkillSet().add(skill);
            skill.getJobSet().add(job);
            return jobRepository.save(job);
        }

        return null;
        //if jobObj is an HR job it would have many skills already
        //so we fetch the skill set and add the new skill to set
    }


    public List<Skill> getAllSkills(){
        return skillsRepository.findAll();
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
}
