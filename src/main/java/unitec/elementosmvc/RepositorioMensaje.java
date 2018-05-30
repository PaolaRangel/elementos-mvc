/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author T-107
 */
//hereda de una interfaz a otra y 5te das cuenta por el extends
public interface RepositorioMensaje extends MongoRepository<Mensaje,String>{
    //pueden haber metodos implicitamente abstracto, no puede haber logica
    public Mensaje findByCuerpo(String cuerpo);
}
