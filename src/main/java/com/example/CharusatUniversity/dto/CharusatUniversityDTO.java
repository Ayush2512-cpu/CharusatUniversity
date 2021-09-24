package com.example.CharusatUniversity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.CharusatUniversity.validation.NamePrefix;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class CharusatUniversityDTO {
    @NamePrefix(message = "Name must start with CRS")
    @NotBlank(message = "Name is required!")
    private String departmentName;
    @NotNull
    @Min(value = 6)
    @Positive(message = "Semester cannot be Zero or negative")
    private int noOfSem;

    public String getdepartmentName() {
        return departmentName;
    }

}
