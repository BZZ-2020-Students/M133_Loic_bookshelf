package ch.bzz.loicbookshelf.service;


import ch.bzz.loicbookshelf.data.DataHandler;
import ch.bzz.loicbookshelf.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("book")

public class Bookservice {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBooks(){
        List<Book> bookList = DataHandler.getInstance().readAllBooks();
        return Response
                .status(200)
                .entity(bookList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readBook(
        @QueryParam("uuid") String bookUUID
    ){
        Book book = DataHandler.getInstance().readBookByUUID(bookUUID);
        return Response
                .status(200)
                .entity(book)
                .build();
    }
}

