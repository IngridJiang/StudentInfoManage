package manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gyt
 */
public class ShowqdBean {
    String[]columnName;
    String[][]tableRecord=null;
    public ShowqdBean(){
     tableRecord = new String[1][1];
     columnName = new String[1];
    }
    public void setTableRecord(String[][] s){
     tableRecord=s;
    }
    public void setColumnName(String[] s){
     columnName=s;
    }
    public String[][] getTableRecord(){
     return tableRecord;
    }
    public String[] getColumnName(){
     return columnName;
    }
}
