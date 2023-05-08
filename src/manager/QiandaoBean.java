/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

/**
 *
 * @author gyt
 */
public class QiandaoBean {
    String gradeName="";
    String ID="";
    public void setID(String ID){
     this.ID=ID;
    }
    public void setGradeName(String gradeName){
     this.gradeName=gradeName;
    }
    
    public String getID(){
       return ID;
    }
    public String getGradeName(){
       return gradeName;
    }
    
}

