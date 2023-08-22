package br.com.carlosjunior.santanderdevweek.service;

import br.com.carlosjunior.santanderdevweek.domain.model.User;

public interface UserService {
    User findById(Long id) throws NoSuchFieldException;

    User create(User userCreate) throws IllegalAccessException;

}