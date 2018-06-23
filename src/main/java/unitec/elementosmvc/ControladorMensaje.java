/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitec.elementosmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //Aplication Package interface
@CrossOrigin
public class ControladorMensaje {
    @Autowired RepositorioMensaje repoMensa;
    
//CASO A) BUSCAR TODOS    
    @GetMapping("/mensaje")
    public List<Mensaje> buscarTodos(){
        
        return repoMensa.findAll();
        
        
    }
    //CASO b) BUSCAR pot ig

    @GetMapping("/mensaje/{id}")
    //las significan que el 
    //necesita introducir un valor conocida como variable de ruta
    public Mensaje buscarPorId(@PathVariable String id){
        Mensaje mensa = new Mensaje();
        mensa.setId(id);
        return repoMensa.findById(id).get();
    
}
    //caso C Guardar
    @PostMapping("/mensaje")
    public Estatus guardar(@RequestBody String json)throws Exception{
        
        //primero convertimos este String json a un objeto java
        ObjectMapper maper=new ObjectMapper();
        Mensaje mensa =maper.readValue(json, Mensaje.class);
        repoMensa.save(mensa);
        System.out.println("este objeto se convirtio:"+mensa);
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Mensaje guardado con exito!!");
                return estatus;
        
    }
    
    //caso d Actualizar
     @PutMapping("/mensaje")
    public Estatus actualizar(@RequestBody String json)throws Exception{
        
        //primero convertimos este String json a un objeto java
        ObjectMapper maper=new ObjectMapper();
        Mensaje mensa =maper.readValue(json, Mensaje.class);
        repoMensa.save(mensa);
        System.out.println("este objeto se convirtio:"+mensa);
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Mensaje guardado con exito!!");
                return estatus;
    }
        //Caso e borrar
@DeleteMapping("/mensaje")
    public Estatus borrarPoRId(@PathVariable String id)throws Exception{
        
        
       
        Mensaje mensa = new Mensaje();
        repoMensa.deleteById(id);
       
        Estatus e = new Estatus();
        e.setSuccess(true);
        e.setMensaje("Mensaje guardado con exito!!");
                return e;
    
    }
    
    

}

