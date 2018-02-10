package unitec.org.elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner {
        //inyeccion de depedencias
    @Autowired RepositorioMensajito repoMensa;
    
	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        //Guardar=insert
       // Mensajito m=new Mensajito("primero","Mi primer mensajito con hibernate");
       //repoMensa.save(m);       
        //Buscar todos=select * from
       /*  ArrayList<Mensajito> mensajito=(ArrayList<Mensajito>) repoMensa.findAll();//casting
         for(Mensajito mensa: mensajito){
             System.out.println(mensa.getTitulo());
         }*/
       //Buscar por id
    //    Mensajito m1= repoMensa.findOne(1);
    //    System.out.println(m1.getTitulo());
        //Actualizacion
       // repoMensa.save(new Mensajito(1,"Otro","malo"));
        //Borrar
      //  repoMensa.delete(1);
    }
}
