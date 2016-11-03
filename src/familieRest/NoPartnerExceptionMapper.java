package familieRest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoPartnerExceptionMapper implements ExceptionMapper<NoPartnerException> {

	@Override
	public Response toResponse(NoPartnerException ex) {
		return Response.status(Response.Status.PRECONDITION_FAILED).build();
	}
}
