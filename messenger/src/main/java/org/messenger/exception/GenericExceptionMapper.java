package org.messenger.exception;

import org.messenger.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 505, "website");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage)
                .type(MediaType.APPLICATION_XML).build();
    }
}
