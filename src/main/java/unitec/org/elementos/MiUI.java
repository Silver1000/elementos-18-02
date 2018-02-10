/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.data.util.*;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


@SpringUI//Primera pagina del tomcat
@Theme ("valo")//Tema de la pagina
public class MiUI extends UI{

 public TextField t1;
 public TextField t2;
 public Integer miId;
 

   
   @Autowired RepositorioMensajito repoMensa;
    @Override
    protected void init(VaadinRequest request) {
        //Agregaremos un layout vertical dentro de el, 
        //las componentes que quedaran en orden descendente vertical
        VerticalLayout layout=new VerticalLayout();
        Label e1=new Label("Andres Silvestre Rodriguez Almader");
        e1.addStyleName(ValoTheme.LABEL_H1);
        
        Button b1=new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_DANGER);
        //Vamos a programar el evento del boton bl
        //usando programacion reactiva
        b1.addClickListener(algo->{
        //Aqui ponemos el evento
        e1.setValue("Mi primer programacion funcional");
        t1 = new TextField();
        t2 = new TextField();
        });
      
        //Agregamos las componentes al layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        // Tabla 
    List<Mensajito> mensajito = (List<Mensajito>) repoMensa.findAll();
   
    
    Grid<Mensajito> grid = new Grid<>();
    grid.setItems(mensajito);
    grid.addColumn(Mensajito::getId).setCaption("Id");
    grid.addColumn(Mensajito::getTitulo).setCaption("Titulo del mensaje");
    grid.addColumn(Mensajito::getCuerpo).setCaption("Cuerpo del mensaje");
    
    grid.setSelectionMode(SelectionMode.SINGLE);
   
    
    grid.addItemClickListener(evento -> {
    Notification.show("Valor: "+evento.getItem().getTitulo());
    t1.setValue(evento.getItem().getTitulo());
    t2.setValue(evento.getItem().getTitulo());
    MiVentana sub =new MiVentana();
    UI.getCurrent().addWindow(sub);
    });
    
        layout.addComponent(grid);
        //esto solo se hace una vez que es agregar el layout a la pagina index
        setContent(layout);
    }
    //clase interna para la ventana
class MiVentana extends Window {

    public MiVentana() {
        super("Actualizar o borrar");
        center();
        VerticalLayout vl2 = new VerticalLayout();

      
       
        
        Button boton = new Button("Actualizar");
        boton.addClickListener(evento -> {
            close();
        });
        vl2.addComponent(t1);
        vl2.addComponent(t2);
        vl2.addComponent(boton);

        setContent(vl2);
    }
}
}
