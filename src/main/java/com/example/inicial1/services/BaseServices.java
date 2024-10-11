package com.example.inicial1.services;

import java.util.List;


import org.springframework.stereotype.Service;

public interface BaseServices<E> {

    //Trae una lista de todas las personas (entidades) que se encuentran en la base de datos
    public List<E> findAll() throws Exception;

    //Trae una entidad de acuerdo a su número de Id
    public E findById(Long id) throws Exception;

    //Crea una nueva entidad. Se le pasa una entidad al repositorio
    public E save(E entity) throws Exception;

    //Actualiza una entidad con los datos que recibe
    public E update(Long id, E entity) throws Exception;

    //Elimina un registro de la base de datos
    public boolean delete(Long id) throws Exception;

}
