/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitec.elementosmvc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    }

