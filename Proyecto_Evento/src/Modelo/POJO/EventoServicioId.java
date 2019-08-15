package Modelo.POJO;
// Generated 14-ago-2019 19:09:39 by Hibernate Tools 4.3.1



/**
 * EventoServicioId generated by hbm2java
 */
public class EventoServicioId  implements java.io.Serializable {


     private int idEvento;
     private int idServicio;

    public EventoServicioId() {
    }

    public EventoServicioId(int idEvento, int idServicio) {
       this.idEvento = idEvento;
       this.idServicio = idServicio;
    }
   
    public int getIdEvento() {
        return this.idEvento;
    }
    
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public int getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EventoServicioId) ) return false;
		 EventoServicioId castOther = ( EventoServicioId ) other; 
         
		 return (this.getIdEvento()==castOther.getIdEvento())
 && (this.getIdServicio()==castOther.getIdServicio());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdEvento();
         result = 37 * result + this.getIdServicio();
         return result;
   }   


}


