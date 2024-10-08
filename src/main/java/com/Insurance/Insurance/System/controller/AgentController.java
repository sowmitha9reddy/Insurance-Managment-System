package com.Insurance.Insurance.System.controller;

import com.Insurance.Insurance.System.dto.AgentDto;
import com.Insurance.Insurance.System.service.AgentDaoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentDaoImpl agentDaoImpl;

    @PostMapping("/addag")
    public AgentDto addPolicyHolder(@Valid @RequestBody AgentDto agentDto) {
        return agentDaoImpl.addAgent(agentDto);
    }

    @GetMapping("/getag/{id}")
    public AgentDto getPolicyHolder(@PathVariable  long id) {
        return  agentDaoImpl.getAgent(id);
    }

    @GetMapping("/getphs")
    public List<AgentDto> getAllPolicyHolders() {
        return agentDaoImpl.getAllAgents();
    }

    @PutMapping("/update/{id}")
    public AgentDto updateEmployee(@PathVariable long id,@Valid @RequestBody AgentDto agentDto) {
        return  agentDaoImpl.updateAgent(id,agentDto);
    }

    @DeleteMapping("/deleteph/{id}")
    public void deleteEmployee(@PathVariable long id) {
        agentDaoImpl.deleteAgent(id);
    }

    @DeleteMapping("/deleteAllEmps")
    public void deleteAllEmployees(){agentDaoImpl.deleteAllAgents();
    }

}
