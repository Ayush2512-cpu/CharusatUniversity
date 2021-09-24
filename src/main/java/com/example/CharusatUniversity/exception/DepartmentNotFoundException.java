package com.example.CharusatUniversity.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Integer id) {
        super("Department not found : " + id);
    }

}
