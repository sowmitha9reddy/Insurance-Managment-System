package com.Insurance.Insurance.System.model;

import com.Insurance.Insurance.System.dto.AgentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Agent")
@Data
//@Setter
//@Getter
//@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Agent {
    // id, name, email, policies
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Policy> policies;

    public Agent(AgentDto agentDto) {
        this.name=agentDto.getName();
        this.email=agentDto.getEmail();
        this.policies=agentDto.getPolicies();
    }
}
