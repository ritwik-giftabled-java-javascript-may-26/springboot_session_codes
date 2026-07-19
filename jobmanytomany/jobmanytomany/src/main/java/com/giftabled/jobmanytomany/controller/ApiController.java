package com.giftabled.jobmanytomany.controller;

import com.giftabled.jobmanytomany.model.Job;
import com.giftabled.jobmanytomany.model.Skill;
import com.giftabled.jobmanytomany.service.JobSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private JobSkillService jobSkillService;

    @PostMapping("/jobs")
    public ResponseEntity<?> saveJob(@RequestBody Job job){
        return new ResponseEntity<>(jobSkillService.saveJob(job), HttpStatus.CREATED);
    }

    @PostMapping("/skills")
    public ResponseEntity<?> saveSkill(@RequestBody Skill skill){
        return new ResponseEntity<>(jobSkillService.saveSkill(skill), HttpStatus.CREATED);
    }

    @PostMapping("/jobs/{jobId}/add-skill/{skillId}")
    public ResponseEntity<?> addSkillToJobId(@PathVariable Long jobId,@PathVariable Long skillId){
        Job job = jobSkillService.addSkillToJobId(jobId,skillId);
        return new ResponseEntity<>(job,HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getAllJobs(){
        return new ResponseEntity<>(jobSkillService.getAllJobs(),HttpStatus.OK);
    }

    @GetMapping("/skills")
    public ResponseEntity<?> getAllSkills(){
        return new ResponseEntity<>(jobSkillService.getAllSkills(),HttpStatus.OK);
    }
}
