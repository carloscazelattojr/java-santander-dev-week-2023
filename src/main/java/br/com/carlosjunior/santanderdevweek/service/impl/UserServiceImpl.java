package br.com.carlosjunior.santanderdevweek.service.impl;

import br.com.carlosjunior.santanderdevweek.domain.model.User;
import br.com.carlosjunior.santanderdevweek.domain.repository.UserRepository;
import br.com.carlosjunior.santanderdevweek.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) throws NoSuchFieldException {
        return repository.findById(id).orElseThrow(NoSuchFieldException::new);
    }

    @Override
    public User create(User userCreate) throws IllegalAccessException {
        if (repository.existsByAccountNumber(userCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        return repository.save(userCreate);
    }
}
