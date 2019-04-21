package views.msg;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
@ManagedBean(name ="Msg")
public class MsgView {
     
    public void buttonAction(ActionEvent actionEvent) {
    	System.out.println("btnAciont..");
        addMessage("Favoritado com sucesso!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
   
    
    
}