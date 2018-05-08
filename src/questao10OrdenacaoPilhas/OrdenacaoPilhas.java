package questao10OrdenacaoPilhas;

import javax.swing.JOptionPane;

/**
 *
 * @author Conrad
 */
public class OrdenacaoPilhas {
    //VARIAVEIS GLOBAIS
    public static int k = 5;
    public static int[] p1 = new int[k];
    public static int[] p2 = new int[k];
    public static int topo = -1;
    public static int topoB = -1;
   
    //INICIO DAS FUNÇÕES-------------------------------------------------------
    public static void push(int valor){ //função para inserir na pilha A
        if(topo < k){
            topo++;
            p1[topo] = valor;
        }
    }//fim função push A
   
    public static void pushB(int vlr){ //função para inserir na pilha B
        if(topoB < k){
            topoB++;
            p2[topoB] = vlr;
        }
    }//fim função push B
   
    public static String exibePilha(){ //função para exibir a pilha A
        String str="";
       
        for (int i = topo; i > -1; i--) {
            str += p1[i];
        }
        return str;
    }
   
    public static String ordStr(String str){ //função para ordenar
        int aux;
        String strR="";
        int[] v = new int[5];
       

        for (int i = topo; i > -1; i--) { //transfere os elementos da pilha para o vetor
            v[i] += p1[i];
        }
       
        for (int i = 0; i < v.length; i++) { //ordena os elementos
            for (int j = i+1; j < v.length; j++) {
                if(v[i]>v[j]){
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                } //fim if 
            } //fim for j
        } //fim for i

        for (int i = 0; i < v.length; i++) {//transfere os elementos para uma string
            int a = v[i];
            pushB(a);
        }
        for (int i = 0; i < v.length; i++) {//transfere os elementos para uma string
            strR += p2[i];
        }
        return strR; //retorna a string ordenada
    }
   
    //INICIO DO MAIN------------------------------------------------------------
    public static void main(String[] args){
        //Variaveis locais
        String str;
        String strOrd;
       
        //pilha A
        push(3);
        push(4);
        push(1);
        push(5);
        push(2);
       
        //uso das funções
        str = exibePilha(); //retorna a pilha A    
        strOrd = ordStr(str); //retorna a pilha B

        //saida
        JOptionPane.showMessageDialog(null, "Pilha A: " + str);
        JOptionPane.showMessageDialog(null, "Pilha B: " + strOrd);
       
    } //fim do main
} //fim da classe
