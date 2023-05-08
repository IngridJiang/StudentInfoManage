/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;


public class zuoyeBean {
    String id;
    String question;
    String choiceA;
    String choiceB;
    String choiceC;
    String choiceD;
    String pdda;
    String jdda;
    String tkda;
    int number;
    String answer;
     String correctAnswer;
     float score;
     float fenzhi;
     String mess;
    public void setNumber(int number){
     this.number=number;
    }
    public int getNumber(){
    return number;
    }
    public void setAnswer(String answer){
     this.answer=answer;
    }
    public String getAnswer(){
    return answer;
    }
     public void setQuestion(String question){
     this.question=question;
    }
    public String getQuestion(){
    return question;
    }
     public void setChoiceA(String choiceA){
     this.choiceA=choiceA;
    }
    public String getChoiceA(){
    return choiceA;
    }
     public void setChoiceB(String choiceB){
     this.choiceB=choiceB;
    }
    public String getChoiceB(){
    return choiceB;
    }
     public void setChoiceC(String choiceC){
     this.choiceC=choiceC;
    }
    public String getChoiceC(){
    return choiceC;
    }
     public void setChoiceD(String choiceD){
     this.choiceD=choiceD;
    }
    public String getChoiceD(){
    return choiceD;
    }
     public void setPdda(String pdda){
     this.pdda=pdda;
    }
    public String getPdda(){
    return pdda;
    }
     public void setTkda(String tkda){
     this.tkda=tkda;
    }
    public String getTkda(){
    return tkda;
    }
     public void setJdda(String jdda){
     this.jdda=jdda;
    }
    public String getJdda(){
    return jdda;
    } 
    public void setCorrectAnswer(String correctAnswer){
     this.correctAnswer=correctAnswer;
    }
    public String getCorrectAnswer(){
    return correctAnswer;
    }
    public void setMess(String mess){
     this.mess=mess;
    }
    public String getMess(){
    return mess;
    }
    public void setScore(float score){
     this.score=score;
    }
    public float getScore(){
    return score;
    }
    public void setFenzhi(float fenzhi){
     this.fenzhi=fenzhi;
    }
    public float getFenzhi(){
    return fenzhi;
    }
}
