package ug.or.nda.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("successrate")
public class SuccessRate {
	
	private Logger logger = Logger.getLogger(getClass());

	@Context
	private UriInfo context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getNumbers(
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate
			) {
		
		String query = context.getBaseUri().getQuery();
		logger.info("\n\t--> query: "+query);
		logger.info("\t--> startDate: "+startDate);
		logger.info("\t--> startDate: "+startDate);
		logger.info("\t--> endDate: "+endDate);
		
		JSONObject wrapper = new JSONObject();
		JSONArray results = new JSONArray();
		
		JSONObject item = new JSONObject();
		item.put("status", "SUCCESS");
		item.put("count", "100");
		results.put(item);
		
		item = new JSONObject();
		item.put("status", "FAILED_TEMPORARILY");
		item.put("count", 4);
		results.put(item);
		
		item = new JSONObject();
		item.put("status", "FAILED_PERMANENTLY");
		item.put("count", 3);
		results.put(item);
		
		
		item = new JSONObject();
		item.put("status", "UNPROCESSED");
		item.put("count", 1);
		results.put(item);
		
		wrapper.put("count", results.length());
		wrapper.put("results", results);
		
		return wrapper.toString();
	}

}
