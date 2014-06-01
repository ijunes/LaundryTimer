package com.ijunes.timer.db;

import com.codahale.dropwizard.hibernate.AbstractDAO;
import com.google.common.base.Optional;
import com.ijunes.timer.core.Machine;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kang on 6/1/2014.
 */

public class MachineDAO extends AbstractDAO<Machine> {
    public MachineDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Machine> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Machine create(Machine machine) {
        return persist(machine);
    }

    public List<Machine> findAll() {
        return list(namedQuery("com.ijunes.timer.core.Person.findAll"));
    }
}


