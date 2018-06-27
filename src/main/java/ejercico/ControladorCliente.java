/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unitec.elementosmvc.RepositorioCliente;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import unitec.elementosmvc.Estatus;

@RestController
@RequestMapping("/api") //Aplication Package interface
@CrossOrigin

public class ControladorCliente {
    @Autowired RepositorioCliente repoCli;
    
    
       @GetMapping("/cliente")
    public List<Cliente> buscarTodos(){
        
        return repoCli.findAll();
        
    } 
    
      @GetMapping("/cliente/{id}")
      //las significan que el 
    //necesita introducir un valor conocida como variable de ruta
    public Cliente buscarPorId(@PathVariable String id){
        Cliente cli = new Cliente();
        return repoCli.findById(id).get();
    
}
    //caso C Guardar
    @PostMapping("/Cliente")
    public Estatus guardar(@RequestBody String json)throws Exception{
        
        //primero convertimos este String json a un objeto java
        ObjectMapper maper=new ObjectMapper();
        Cliente cli =maper.readValue(json, Cliente.class);
        repoCli.save(cli);
        System.out.println("este objeto se convirtio:"+cli);
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Mensaje guardado con exito!!");
                return estatus;
        
    }
    
    //caso d Actualizar
     @PutMapping("/Cliente")
    public Estatus actualizar(@RequestBody String json)throws Exception{
        
        //primero convertimos este String json a un objeto java
        ObjectMapper maper=new ObjectMapper();
        Cliente cli =maper.readValue(json, Cliente.class);
        repoCli.save(cli);
        System.out.println("este objeto se convirtio:"+cli);
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("Cliente guardado con exito!!");
                return estatus;
    }
        //Caso e borrar
@DeleteMapping("/Cliente")
    public Estatus borrarPoRId(@PathVariable String id)throws Exception{
        
        
       
        Cliente cli = new Cliente();
        repoCli.deleteById(id);
       
        Estatus e = new Estatus();
        e.setSuccess(true);
        e.setMensaje("Cliente guardado con exito!!");
                return e;
    
 

    }
}