package com.Insurance.Insurance.System.service;

import com.Insurance.Insurance.System.dto.AgentDto;
import com.Insurance.Insurance.System.exception.AgentNotFoundException;
import com.Insurance.Insurance.System.service.interfacess.AgentDao;
import com.Insurance.Insurance.System.model.Agent;
import com.Insurance.Insurance.System.model.Claim;
import com.Insurance.Insurance.System.model.Policy;
import com.Insurance.Insurance.System.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentDaoImpl implements AgentDao {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public  AgentDto addAgent(AgentDto agentDto) {
        Agent agent=new Agent(agentDto);

        List<Policy> policies=agentDto.getPolicies();
        if(policies!=null){
            policies.forEach(policy -> {
                policy.setAgent(agent);
                List<Claim> claims = policy.getClaims();
                if (claims != null) {
                    claims.forEach(claim -> claim.setPolicy(policy));
                }
            });

        }
        return mapToDto(agentRepository.save(agent));


    }
    public  AgentDto mapToDto(Agent agent){

        AgentDto agentDto=new AgentDto();

        agentDto.setName(agent.getName());
        agentDto.setEmail(agent.getEmail());
        agentDto.setPolicies(agent.getPolicies());
        return agentDto;

    }


    @Override
    public AgentDto getAgent(long id) {
       return  mapToDto(agentRepository.findById(id).orElseThrow(() -> new AgentNotFoundException("Agent Not found")));
    }

    @Override
    public List<AgentDto> getAllAgents() {
        return agentRepository.findAll().stream().map(agent -> mapToDto(agent)).collect(Collectors.toList());
    }

    @Override
    public AgentDto updateAgent(long id, AgentDto agentDto) {
        Agent agentData=agentRepository.findById(id).orElseThrow(() -> new AgentNotFoundException("Agent id not found"));

        if(agentData!=null) {
            agentData.setName(agentDto.getName());
            agentData.setEmail(agentDto.getEmail());
            List<Policy> policies=agentDto.getPolicies();
            policies.forEach(policy -> policy.setAgent(agentData));
           agentData.setPolicies(policies);
            return mapToDto(agentRepository.save(agentData));
        }
        return null;

    }

    @Override
    public void deleteAgent(long id) {
       AgentDto agentDto=getAgent(id);
       Agent agent=new Agent(agentDto);
       agentRepository.delete(agent);
    }

    @Override
    public void deleteAllAgents() { agentRepository.deleteAll();
    }


}
