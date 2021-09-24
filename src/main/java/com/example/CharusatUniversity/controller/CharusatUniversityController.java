package com.example.CharusatUniversity.controller;


import com.example.CharusatUniversity.dto.CharusatUniversityDTO;
import com.example.CharusatUniversity.entity.CharusatUniversity;
import com.example.CharusatUniversity.exception.DepartmentNotFoundException;
import com.example.CharusatUniversity.mapper.CharusatUniversityMapper;
import com.example.CharusatUniversity.service.ICharusatUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CharusatUniversityController {
    @Autowired
    ICharusatUniversityService charusatUniversityService;

    @GetMapping("/greetings")
    ResponseEntity getWelcomeMessage() {
        return ResponseEntity.ok().body("Welcome to the world of Charusat!!!!!");
    }

    @GetMapping(value = "/department")
    List<CharusatUniversity> getAll() {
        return charusatUniversityService.getAllDetails();
    }

    @GetMapping(value = "/department/{id}")
   ResponseEntity<CharusatUniversity> getById(@PathVariable("id") @Min(1) int id) {
        CharusatUniversity crs = charusatUniversityService.findById(id)
                    .orElseThrow(()->new DepartmentNotFoundException(id));
            return ResponseEntity.ok().body(crs);

       // return this.charusatUniversityService.getDetails(id);
    }

    @PostMapping(value="/department", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createDepartment(@Valid @RequestBody CharusatUniversity department) {
      //  CharusatUniversity department = CharusatUniversityMapper.DtoToEntity(indep);
        CharusatUniversity addeddep = charusatUniversityService.save(department);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addeddep.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

//    @PostMapping("/department")
//    public CharusatUniversity setDetails(@RequestBody CharusatUniversity p) {
//
//         return this.charusatUniversityService.setDetails(p);
//        //return ResponseEntity.created(location).build();
//    }

//    @PutMapping(value = "/department/{id}")
//    public CharusatUniversity updateDetails(@PathVariable int id,@RequestBody CharusatUniversity p) {
//
//        return this.charusatUniversityService.changeDetails(p,id);
//    }
//
//    @DeleteMapping(value = "/department/{id}")
//    public void deleteDetails(@PathVariable int id) {
//        this.charusatUniversityService.deleteDetails(id);
//    }

    @PutMapping(value="/courses/{id}")
    ResponseEntity<CharusatUniversity> updateDepartment(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody CharusatUniversity indepartment) {
        CharusatUniversity department = charusatUniversityService.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException(id));

      //  CharusatUniversity newdep = CharusatUniversityMapper.DtoToEntity(indepartment);
        indepartment.setId(indepartment.getId());
        charusatUniversityService.save(indepartment);
        return ResponseEntity.ok().body(indepartment);
    }
    @DeleteMapping(value="/department/{id}")
    ResponseEntity deleteDepartment(@PathVariable("id") @Min(1) int id) {
        CharusatUniversity department = charusatUniversityService.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException(id));
        charusatUniversityService.delete(department.getId());
        return ResponseEntity.ok().body("Department with ID : "+id+" deleted with success!");
    }
}