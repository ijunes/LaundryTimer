package com.ijunes.timer.resources;

import com.codahale.dropwizard.hibernate.UnitOfWork;
import com.codahale.dropwizard.jersey.params.LongParam;
import com.google.common.base.Optional;
import com.ijunes.timer.core.Machine;
import com.ijunes.timer.core.Person;
import com.ijunes.timer.db.MachineDAO;
import com.ijunes.timer.db.PersonDAO;
import com.ijunes.timer.views.MachineView;
import com.ijunes.timer.views.PersonView;
import com.sun.jersey.api.NotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by kang on 6/1/2014.
 */
    @Path("/machines/{machineId}")
    @Produces(MediaType.APPLICATION_JSON)
    public class MachineResource {

        private final MachineDAO machinesDAO;

        public MachineResource(MachineDAO machinesDAO) {
            this.machinesDAO = machinesDAO;
        }

        @GET
        @UnitOfWork
        public Machine getMachine(@PathParam("machineId") LongParam machineId) {
            return findSafely(machineId.get());
        }

        private Machine findSafely(long machineId) {
            final Optional<Machine> machine = machinesDAO.findById(machineId);
            if (!machine.isPresent()) {
                throw new NotFoundException("No such user.");
            }
            return machine.get();
        }

        @GET
        @Path("/view_freemarker")
        @UnitOfWork
        @Produces(MediaType.TEXT_HTML)
        public MachineView getMachineViewFreemarker(@PathParam("machineId") LongParam machineId) {
            return new MachineView(MachineView.Template.FREEMARKER, findSafely(machineId.get()));
        }

        @GET
        @Path("/view_mustache")
        @UnitOfWork
        @Produces(MediaType.TEXT_HTML)
        public MachineView getMachineViewMustache(@PathParam("machineId") LongParam machineId) {
            return new MachineView(MachineView.Template.MUSTACHE, findSafely(machineId.get()));
        }
    }

