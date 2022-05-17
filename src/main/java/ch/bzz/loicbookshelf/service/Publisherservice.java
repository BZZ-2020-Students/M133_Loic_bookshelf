package ch.bzz.loicbookshelf.service;


import ch.bzz.loicbookshelf.data.DataHandler;
import ch.bzz.loicbookshelf.model.Book;
import ch.bzz.loicbookshelf.model.Publisher;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("publisher")

public class Publisherservice {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPublisher(){
        List<Publisher> publisherList = DataHandler.getInstance().readAllPublishers();
        return Response
                .status(200)
                .entity(publisherList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPublisher(
            @QueryParam("uuid") String publisherUUID
    ){
        int httpStatus = 200;
        Publisher publisher = DataHandler.getInstance().readPublisherByUUID(publisherUUID);
        if(publisher== null){
            httpStatus=410;
        }
        return Response
                .status(200)
                .entity(publisher)
                .build();
    }
}

