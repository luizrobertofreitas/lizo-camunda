package org.lizo.camunda.service;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.lizo.camunda.business.ProcessBusiness;
import org.lizo.camunda.service.vo.LizoProcess;

/**
 * Processes REST service.
 * 
 * @author accurate
 *
 */
@Path("/processes")
public class ProcessRestService {
	
	private final ProcessBusiness pb = new ProcessBusiness();
	
	/**
	 * Create POST method.
	 * 
	 * @return Response
	 */
	@POST
	@Produces({MediaType.APPLICATION_XML})
	public LizoProcess create() {
//		return Response.status(200).entity(pb.create()).build();
		return pb.create();
	}
	
	/**
	 * List GET method.
	 * 
	 * @param page
	 * @param size
	 * @return Response
	 */
	@GET
//	@Produces({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON})
	public List<LizoProcess> list(
			@QueryParam("page") @DefaultValue("1") final int page, 
			@QueryParam("size") @DefaultValue("10") final int size
			) {
		return pb.findAll(page, size);
	}
	
}
