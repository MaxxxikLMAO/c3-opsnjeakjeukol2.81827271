package cz.educanet.mavenz;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)

public class UsersResource {

    @Inject
    private UserManager userManager;
    @Inject
    private LoginManager loginManager;

    @POST
    public Response register(

            @FormParam("firstName") String firstName, //[FORM PARAM] dává označení. Beru to z body requestu.
            @FormParam("surname") String surname, //[FORM PARAM] dává označení. Beru to z body requestu.
            @FormParam("username") String username, //[FORM PARAM] dává označení. Beru to z body requestu.
            @FormParam("password") String password, //[FORM PARAM] dává označení. Beru to z body requestu.
            @FormParam("email") String email //[FORM PARAM] dává označení. Beru to z body requestu.

    ) {

        User tempUser = new User(username, password, firstName, surname , email);

        if (userManager.existByUsername(username)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            userManager.userInfoStorage(tempUser);
            return Response.ok(" Uživatel byl úspěšně zaregistrován! ").build();
        }
    }

    @POST
    public Response login(
            @FormParam("username") String username,
            @FormParam("password") String password

    ) {
        User tempLog = userManager.getUserByUsernameNPass(username, password);
        if(tempLog == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            loginManager.adudewhohasunironicallyloggedin = tempLog;
            return Response.ok("Uživatel se úspěšně zaloginoval elemejou").build();
        }
    }

    public Response logout(){
        loginManager.adudewhohasunironicallyloggedin = null;
        return Response.ok("uživatel se odhlásil").build();
    }

    public Response getCurrentUser() {
        if(loginManager.adudewhohasunironicallyloggedin == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
            return Response.ok(loginManager.adudewhohasunironicallyloggedin.getUsername()).build();
        }
    }
}

/*UsersResource us = new UsersResource();
us.name
UsersResource us2 = new UsersResource();
us2.name*/
// users.add("Marek");
