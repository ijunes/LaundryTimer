package com.ijunes.timer.resources;

import com.ijunes.timer.core.Person;
import com.ijunes.timer.db.PersonDAO;
import com.ijunes.timer.views.PersonView;
import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import com.codahale.dropwizard.hibernate.UnitOfWork;
import com.codahale.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people/{personId}")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GET
    @UnitOfWork
    public Person getPerson(@PathParam("personId") LongParam personId) {
        return findSafely(personId.get());
    }

	private Person findSafely(long personId) {
		final Optional<Person> person = peopleDAO.findById(personId);
        if (!person.isPresent()) {
            throw new NotFoundException("No such user.");
        }
		return person.get();
	}

    @GET
    @Path("/view_freemarker")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public PersonView getPersonViewFreemarker(@PathParam("personId") LongParam personId) {
        return new PersonView(PersonView.Template.FREEMARKER, findSafely(personId.get()));
    }
    
    @GET
    @Path("/view_mustache")
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public PersonView getPersonViewMustache(@PathParam("personId") LongParam personId) {
    	return new PersonView(PersonView.Template.MUSTACHE, findSafely(personId.get()));    
    }
}
