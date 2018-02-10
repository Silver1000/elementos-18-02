/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.elementos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Se mapearan con JPA (javax.persistence)
@Entity
public class Mensajito {
    
    @Id
    //@Column(name='id') Es opcional, se realiza en caso de que el nombre sea diferente a la tabla realizada e importar 
    @GeneratedValue// Cuando la pk se autoincrementa lleva esta instruccion e importar 
    private Integer id ;
    private String titulo;
    private String cuerpo;
    
    public Mensajito(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }        

       public Mensajito() {
    }

    public Mensajito(Integer id) {
        this.id = id;
    }
    public Mensajito(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
