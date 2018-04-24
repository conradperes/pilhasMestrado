package pilhaEncadeada;

import java.util.ArrayList;
public class Pilha {
   //Variavel para definição do topo da pilha.
   Nodo topo = null;
   //Método que empilha valores.
   public void empilha(String valor){
      Nodo novo = new Nodo();
      novo.setValor(valor);
      novo.setAnterior(topo);
      topo = novo;
   }
   //Método para desempilhar valores
   public String Desempilha() throws EmptyStackException{
      if(topo == null){
         throw new EmptyStackException("A pilha está vazia");
      }
      else{
         String valor = topo.getValor();
         topo = topo.getAnterior();
         return valor;
      }
   }
   public String topo()throws EmptyStackException{
	   if(topo==null) {
		   throw new EmptyStackException("Pilha vazia");
	   }else
		   return topo.getValor();
   }
   
   
   //Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em um ArrayList
   public ArrayList<String> Listar() throws EmptyStackException{
      if(topo == null){
         throw new EmptyStackException("A pilha está vazia");
      }
      else{
         ArrayList<String> listar = new ArrayList<String>();
         Nodo aux = topo;      
         while(aux != null){
            listar.add(aux.getValor());
            aux = aux.getAnterior();
         }      
         return listar;
      }
   }
 //Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em um ArrayList
   public String obtemPrimeiroElemento() throws EmptyStackException{
      if(topo == null){
         throw new EmptyStackException("A pilha está vazia");
      }
      else{
         ArrayList<String> listar = new ArrayList<String>();
         Nodo aux = topo;      
         while(aux != null){
            listar.add(aux.getValor());
            aux = aux.getAnterior();
         } 
         int i=0;
         for (String elemento : listar) {
        	 i++;
			if(i==listar.size())
				return elemento;
        	 
		}
         return null;
      }
   }
}
