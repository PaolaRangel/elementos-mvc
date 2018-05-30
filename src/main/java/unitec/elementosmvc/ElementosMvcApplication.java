package unitec.elementosmvc;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ElementosMvcApplication implements CommandLineRunner {

    @Autowired
    ServicioTarjeta servicio;
    @Autowired
    RepositorioMensaje repoMensaje;

    public static void main(String[] args) {
        SpringApplication.run(ElementosMvcApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        //servicio.obtenerSaldo().obtenerSaldo();
        LocalDate fecha = LocalDate.now();
        //repoMensaje.save(new Mensaje("Hola",fecha,"cerdito"));

        //buscar todos los mensajes ya
        //for(Mensaje mensa: repoMensaje.findAll()){
       // System.out.println(mensa);
       // }
        
        //buscar mensaje por id
        
        System.out.println(repoMensaje.findByCuerpo("cerdito"));
        //actualizar un mensaje
        //sigue borara
       // Mensaje m=new Mensaje();
        //m.setId("Hola");
       // repoMensaje.delete(m);
      
    }
}
