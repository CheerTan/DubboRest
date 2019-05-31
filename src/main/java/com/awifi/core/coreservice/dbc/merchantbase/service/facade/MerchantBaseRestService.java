package com.awifi.core.coreservice.dbc.merchantbase.service.facade;

import javax.ws.rs.*;

/**
 * @author Bill Lau
 * @date 2019-05-30
 */
@Path("/merchant")
@Consumes({"application/json", "text/xml"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface MerchantBaseRestService {
    @POST
    String add(String var1);

    @PUT
    String update(String var1);

    @GET
    String queryById(@QueryParam("params") String var1);

    @GET
    @Path("/list")
    String queryListByParam(@QueryParam("params") String var1);

    @GET
    @Path("/count")
    String queryCountByParam(@QueryParam("params") String var1);

    @PUT
    @Path("/cascade")
    String updateCascade(String var1);
}