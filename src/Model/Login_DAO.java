/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Menu_GUI;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;


public class Login_DAO {
    
    public static void ValidaLogin() throws InterruptedException{
        String usu = View.Login_GUI.usuario.getText();
        String senha = View.Login_GUI.senha.getText();
        
        if(senha.equals("admin123")){
            JOptionPane.showMessageDialog(null,"Login feito com sucesso!");
            sleep(1000);
            new Menu_GUI().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Login feito sem sucesso!");
            System.exit(0);
        }
    }
}
