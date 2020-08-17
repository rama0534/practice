package org.messenger.exception;

import org.messenger.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "website");
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage)
                .type(MediaType.APPLICATION_XML).build();
    }


}
