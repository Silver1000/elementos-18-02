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
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI//Primera pagina del tomcat
@Theme ("valo")//Tema de la pagina
public class MiUI extends UI{

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
        });
        
        //Agregamos las componentes al layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        //esto solo se hace una vez que es agregar el layout a la pagina index
        setContent(layout);
    }
    
}
