/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.proyectojsfii.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *clase que recibe los datos de Formulario para ser calculados y mostrados en otro formulario
 * @author david
 */
@Named(value = "resultado")
@RequestScoped
public class Resultado  {
    
    private int total;
   
    /**
     * Creates a new instance of Resultado
     */
    public Resultado() {
    }
    
    @Inject  
    private Formulario formulario;
    
    public String calcular (){
        total = 0;
        if(formulario.getNivelEstudio().equals("tecnico")){
            total= formulario.getDiasTrabajados()*5000;
        }else if(formulario.getNivelEstudio().equals("tecnologo")){
              total = formulario.getDiasTrabajados()*15000;
              
            }else if(formulario.getNivelEstudio().equals("profesional")){
                total = formulario.getDiasTrabajados()*30000;
                
            }else if(formulario.getNivelEstudio().equals("magister")){
                total = formulario.getDiasTrabajados()*40000;
            }
        total = total + formulario.getIdioma().length*10000*formulario.getDiasTrabajados();
        total = total + formulario.getSueldoBase()*formulario.getDiasTrabajados();
        
        return("/resultado");
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
    
    
   

    
    
    
}
