package es.ugr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class Servicio {


    @GET
    @Path("/gameJSON")
    @Produces({"application/json"})
    public Videojuegos getJuegos_JSON() {
        Videojuegos juegos = new Videojuegos();
        juegos.setName("Prueba");
        juegos.setDesc("Pruebaaaaaaaaaaaaaa");
        juegos.setLink("Zelda");
        juegos.setImg("agen");
        juegos.setPrecio(10.0);
        return juegos;
    }

    private static Map<String, Videojuegos> myMap = new HashMap<>();

    static {

        myMap.put("Minecraft", new Videojuegos("Minecraft","Minecraft es un videojuego de construcción, de tipo mundo abierto o sandbox","https://www.minecraft.net/es-es/","https://images-na.ssl-images-amazon.com/images/I/512dVKB22QL._SL500_AA300_.png",25.0));
        myMap.put("Portal", new Videojuegos("Portal","Portal es un videojuego de lógica en primera persona para un solo jugador desarrollado por Valve Corporation","https://www.valvesoftware.com/es/","https://lh3.googleusercontent.com/proxy/HWR8YkdgEEIE9yiWhJCpPHgK9zRdcsHvCQkw5Ei6GTtywXR7U-WY7wDSlJw28cWSRFF1y9Be24B2AnIPi4Ve4VZNnSYXhPbLyCvUvMF6kl7A",10.0));
        myMap.put("Terraria", new Videojuegos("Terraria","Terraria es un videojuego de acción, aventura y de sandbox producido de forma independiente por el estudio Re-Logic","https://terraria.org/","https://store.playstation.com/store/api/chihiro/00_09_000/container/CL/es/999/UP4040-PCSE00317_00-TERRARIA00000001/1588602600000/image?w=240&h=240&bg_color=000000&opacity=100&_version=00_09_000",15.0));
    }

    @POST
    @Path("/modifyGame")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Videojuegos modifyGame(@FormParam("name") String nombre, @FormParam("desc") String descripcion,
            @FormParam("link") String url, @FormParam("img") String imagen, @FormParam("precio") double coste) {
        boolean existe = myMap.containsKey(nombre);
        Videojuegos nuevojuego = new Videojuegos();
        if(existe){
            nuevojuego.setName(nombre);
            nuevojuego.setDesc(descripcion);
            nuevojuego.setLink(url);
            nuevojuego.setImg(imagen);
            nuevojuego.setPrecio(coste);
            myMap.put(nombre, nuevojuego);
        }
        return nuevojuego;
    }
    
        @POST
    @Path("/insertGame")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Videojuegos insertGame(@FormParam("name") String nombre, @FormParam("desc") String descripcion,
            @FormParam("link") String url, @FormParam("img") String imagen, @FormParam("precio") double coste) {
        boolean existe = myMap.containsKey(nombre);
        Videojuegos nuevojuego = new Videojuegos();
        if(!existe){
            nuevojuego.setName(nombre);
            nuevojuego.setDesc(descripcion);
            nuevojuego.setLink(url);
            nuevojuego.setImg(imagen);
            nuevojuego.setPrecio(coste);
            myMap.put(nombre, nuevojuego);
        }
        return nuevojuego;
    }
    
    @POST
    @Path("/deleteGame")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Videojuegos> DeleteGame(@FormParam("name") String nombre) {
        myMap.remove(nombre);
        ArrayList<Videojuegos> juegos = new ArrayList<Videojuegos>();
        juegos.addAll(myMap.values());
        return juegos;
    }
    
    @GET
    @Path("/getAllGames")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Videojuegos> getAllGames() {
        ArrayList<Videojuegos> juegos = new ArrayList<Videojuegos>();
        juegos.addAll(myMap.values());
        return juegos;

    }

}