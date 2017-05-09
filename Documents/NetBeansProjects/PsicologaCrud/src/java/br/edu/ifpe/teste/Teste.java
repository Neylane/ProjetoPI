/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.teste;


import br.edu.ifpe.hibernate.util.JDBCPsicologa;
import br.edu.ifpe.ifpe.model.PsicologaCrud;


/**
 *
 * @author kelly silva
 */
public class Teste {

    public static void main(String[] args) {
             // PsicologaDao psi= new PsicologaDao(); 
              JDBCPsicologa psi = JDBCPsicologa.getInstance();
              PsicologaCrud psicologa;
        psicologa = new PsicologaCrud(123, "Marta", "555445544", 4555555, "marta@hotmail.com");
        //são as informações que mostra na table psicologa crud onde pode inserir alterar, deletar, atualizar.
                                  //códLicença: 123
                                  //nome: kelly
                                  //CPF:54454445
                                  // telefone: 233434
                                  //email:kelly_silva437@gmail.com
     //   psi.salvar(psicologa);
     psi.insertOrUpdate(psicologa);
    }
}
