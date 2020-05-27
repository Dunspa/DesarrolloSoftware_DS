package es.ugr;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Videojuegos {
    private String name;
    private String desc;
    private double precio;
    private String link;
    private String img;
    
    public Videojuegos(){}; //Hay que declarar un constructor vacío
    
    public Videojuegos(String nombre, String descripcion, String url, String imagen,
            double coste){
        this.name = nombre;
        this.desc = descripcion;
        this.precio = coste;
        this.img = imagen;
        this.link = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    /*
    private String imagen;
    private String nombre;  
    private String descripcion;
    private String link;
    private double precio;
    
    public Videojuegos(){}; 
    
    public Videojuegos(String imagen, String nombre, String descripcion ,double precio, 
            String link){
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    public double getPrecio() {
        return precio;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    */
    

}