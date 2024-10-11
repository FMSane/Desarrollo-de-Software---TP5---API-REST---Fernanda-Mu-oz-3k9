package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServices implements BaseServices<Persona>{

    //Cumple la misma función del constructor comentado de abajo.
    //@Autowired

    private PersonaRepository personaRepository;

    //Al constructor no lo llamamos de ningún llado, Spring va a ser el encargado de obtener las dependencias que necesita el servicio.
    public PersonaServices(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @Override
    //Los métodos van a ser transacciones con la base de datos.
    //Indica que antes de cada método se va a tener que hacer un transaction beggin, y un commit, y si ocurre un error, un rollback.
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(entity);
            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


}
