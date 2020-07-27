package pendzu.sduteam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pendzu.sduteam.models.Role;
import pendzu.sduteam.models.RoleName;
import pendzu.sduteam.repositories.IRoleRepository;
import pendzu.sduteam.services.IRoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository repository;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return repository.findByName(roleName);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Role save(Role model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
