package com.Insurance.Insurance.System.dto;

import com.Insurance.Insurance.System.model.Policy;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AgentDto {

    @NotEmpty
    @Pattern(regexp = "^[A-Z][a-z]{3,}$",message="Invalid Name")
    private String name;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,7}$",message="Invalid Email address")
    private String email;


    private List<Policy> policies;
}
