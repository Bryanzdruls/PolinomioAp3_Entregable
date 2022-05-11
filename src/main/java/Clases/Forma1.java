/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author goku3
 */
public class Forma1 {
    //Atributos.
    private int Vpf1[], Du, n;
    
     //metodos.
    public Forma1(int tam)//Constructor 
    {
        
        n = tam;
        Du=n-1;
        Vpf1 = new int[n];                     
    }   
    
    public Forma1()//Sobrecarga de Constructor 
    {       
        Du=n-1;
        Vpf1 = new int[n];               
        
    }   
    public int[] getVpf1() {
        return Vpf1;
    }

    public int getDu() {
        return Du;
    }

    public int getN() {
        return n;
    }

    public void setVpf1(int[] Vpf1) {
        this.Vpf1 = Vpf1;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public int getVpf1(int pos) {
        return Vpf1[pos]; 
    }
    
    public void setVpf1(int pos, int d) {
        Vpf1[pos] = d;
    }
    public void dimensionar(int tam)
    {
        Vpf1=new int [tam];
    }
    public  Forma1 ConvertirF1(String Vs[], Forma1 pf1)//convertir BUENO
    {     
        int i = 0 ,Grado=0, K=0 , Pos , h=0 ;   
        int Aux[]=new int[Vs.length];
        for(int j=0;Vs[i]!=null;j++){
            Aux[j]=Integer.parseInt(Vs[i]);
            i++;            
        }
        for(int p=1;p <=Aux.length-2 ;p+=2)
        {
            if(Grado < Aux[p]){
                Grado=Aux[p];
            }            
        }                      
        pf1.setN(Grado+2);
        pf1.setDu(Grado+1);
        pf1.Vpf1 = new int [Grado+2];        
        pf1.setVpf1(0, Grado);
        for(int j=0;Aux[j] !=0 ;j+=2){
            Pos=pf1.Du-Aux[j+1];
            pf1.setVpf1(Pos, Aux[j]);
        }      
        return pf1;        
    }//Fin COnvertirF1
    
    public Forma1 redimensionar(Forma1 a)//por probar
    {
        Forma1 newVpf1;
        newVpf1 = new Forma1(a.getDu());
        newVpf1.setDu(a.getDu());
        for (int i = 0; i <newVpf1.getDu(); i++)
        {
            newVpf1.setVpf1(i,getVpf1(i));          
        }
        return newVpf1;
    }
    
    public void evaluarPolinomiof1(Forma1 a)//Evaluar BUENO!!!
    {
        int i =1,x,exp  , resul=0;
        x = Integer.parseInt((JOptionPane.showInputDialog(null, "Ingrese un valor para x: ")));
        while(i<=a.getDu())
        {
            exp=a.getDu()-i;
            if(a.getVpf1(i)==1 && a.getVpf1(i)==-1)
            {
                resul+=x;
            }
            if (exp ==0)
            {
                resul = resul + a.getVpf1(i);
            }
            else 
            {      
                resul =(int) (resul +  (a.getVpf1(i)*(Math.pow(x,exp))));
            }
            i++;
        }
        System.out.println("\nEl resultado del polinomio evaluado es: \n"+resul);
    }//Evaluar polinomio
   
    public Forma1 sumar(Forma1 a, Forma1 b)//bueno
    {   
        int expA=0, expB=0, i=1, j=1, k=1;
        Forma1 c = new Forma1(a.getDu()+b.getDu()+2);
        if(a.getVpf1(0)>b.getVpf1(0))
        {
            c.setVpf1(0, a.getVpf1(0));
        }
        else
        {
            c.setVpf1(0, b.getVpf1(0));
        }
        while(k< c.getN())
        {
           expA=a.getDu()-i;
           expB=b.getDu()-j;
           if(expA==expB)
           {
               c.setVpf1(k, a.getVpf1(i)+b.getVpf1(j));
               i++;
               j++;
               k++;
           }
           else
           {
                if(expA>expB)
                {
                    c.setVpf1(k, a.getVpf1(i));
                    i++;
                    k++;
                }
                else
                {
                    c.setVpf1(k, b.getVpf1(j));
                    j++;
                    k++;
                }
           }
        }
        return c;
    }//Fin suma  
    
    public Forma1 Ajustar(Forma1 a)//Por probar
    {
        int cont=0, i=1;
        if(this.getVpf1(1)==0)
        {
             while(i<=a.getDu()-1)
            {
                if(a.getVpf1(i)==0)
                {
                    cont++;
                }
                else
                {
                    
                }
                i++;       
            }
            for (int j = 0; j <a.getDu()-1; j++) {
                a.setVpf1(a.getVpf1(j), j-cont);
            }
            a.setDu(a.getDu()-cont);
            a.setVpf1(a.getDu()-2,0);
        }else{
            System.out.println("No es apto para Ajustarse.");
        }      
        return a;
    }//Fin ajustar
    
    public void mostrar(Forma1 a)//Mostrar BUENO
    {      
        for (int i = 0; i <= a.getDu(); i++)
        {
            System.out.print("|" + a.getVpf1(i));
        }//Fin for     
    }//Fin mostrar
    
    public  void reconstruir()//BUENO
    {//Reconstruir polinomio en forma 1
        int Exp;        
        for (int i = 1; i <= getN() - 1; i++) {
            if (getVpf1(i) != 0) {
                if (getVpf1(i) < 0) {
                    if (getVpf1(i) < 0 && getVpf1(i) != -1) {
                        System.out.print(getVpf1(i));
                        Exp = getDu() - i;
                        if (Exp != 0) {
                            if (Exp == 1) {
                                System.out.print("x");
                            } else {
                                System.out.print("x^" + Exp);
                            }
                        } 
                    } else {
                        Exp = getDu() - i;
                        if (Exp != 0) {
                            if (Exp == 1) {
                                System.out.print("-x");
                            } else {
                                System.out.print("-x^" + Exp);
                            }
                        }else{
                            System.out.print(getVpf1(i));
                        }                  
                    }
                } else {
                    if (i != 1) {
                        if (getVpf1(i) > 0 && getVpf1(i) != 1) {
                            System.out.print("+" + getVpf1(i));
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } /*else {
                                System.out.print("+" + getVpF1(i));
                            }*/
                        } else {
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        }
                    } else {
                        if (getVpf1(i) > 0 && getVpf1(i) != 1) {
                            System.out.print(getVpf1(i));
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        } else {
                            Exp = getDu() - i;
                            if (Exp != 0) {
                                if (Exp == 1) {
                                    System.out.print("x");
                                } else {
                                    System.out.print("x^" + Exp);
                                }//else
                            } else {
                                System.out.print("+" + getVpf1(i));
                            }
                        }
                    }
                }//else
            }
        }//fin for
        System.out.println("\n");
    }//fin reconstruir.            
    public  Forma1 insertarTermino(Forma1 Pf1,int coe, int exp)
    {
        int i=1, j=0, aux[]=new int[Pf1.getN()-1], expA=0;
        
        while(i<Pf1.getN())
        {
            expA=Pf1.getDu()-i;
            if(expA==exp)
            {
                Pf1.setVpf1(i, coe+ Pf1.getVpf1(i));
                System.out.println("\nEl polinomio que así: ");
                Pf1.mostrar(Pf1);
                return Pf1;
            }
            else
            {
                if(expA>exp)
                {
                    i++;
                }
                else
                {
                    Forma1 Pol1 = new Forma1(Pf1.getN()+1);
                    for (int k = 0; k <=Pf1.getDu(); k++) 
                    {
                        Pol1.setVpf1(k, Pf1.getVpf1(k));
                    }                   
                    Pol1.setVpf1(0, exp);
                    i=1;
                    while(i<Pf1.getN())
                    {
                        aux[j] = Pf1.getVpf1(i);
                        i++;
                        j++;
                    }
                    i=1;
                    Pol1.setVpf1(i, coe);
                    i=0; j=2;                  
                    while(i<aux.length)
                    {
                        Pol1.setVpf1(j, aux[i]);
                        i++;
                        j++;
                    }
                    System.out.println("\nEl polinomio queda: ");
                    Pol1.mostrar(Pol1);
                    return Pol1;
                }
            }
        }       
       return Pf1;
    }//Fin Insertar termino
    
    public Forma1 borrarTermino(int coe, int exp)
    {
        Forma1 aux=null;
        int  i=1, expA=0, x=0, pos=0;
        x=exp-this.getVpf1(0);
        //2x^2+x+1
        if(exp > this.Vpf1[0])
        {
            System.out.println("");
        }
        else
        {
            for (int j = 0; j < this.getDu(); j++)
            {
                expA=this.getDu()-j;
                if(expA==exp) //en el caso de que exponen sea igual al grado
                {
                    //buscar y sumar
                    while(i<=this.getDu())
                    {
                        expA=this.getDu()-i;
                        if(expA==exp)
                        {
                            this.setVpf1(i, this.getVpf1(i)+coe);
                        }
                        i++;
                    }
                    System.out.println("");
                    System.out.println("El nuevo forma 1 es:");
                    for(i=0; i<=this.getDu(); i++)
                    {
                        System.out.print("|"+this.getVpf1(i));
                    }
                 }
            }      
            
        }//FIn else
        return this;
    }//Fin BorrarTermino
    public Forma1 multiplicacionF1(Forma1 a, Forma1 b)//Mala
    {        
        int expA, expB, i=1, j=1 ,k=1;
        Forma1 c= new Forma1(a.getDu()+b.getDu());
        c.setVpf1(0,a.getVpf1(0)+b.getVpf1(0));
        while (i<a.getN())
        {   
            k=1;
            while (j<b.getN()) 
            {                
                
                c.setVpf1(k,(c.getVpf1(k)+(a.getVpf1(i)*b.getVpf1(j))));
                j++;
                k++;
            }
            if (i==a.getN()) {
                i=1;
            }else{
                i++;
            }
        }
        this.mostrar(c);
        return c;
 
    }//FIn multiplicacion

    private void pow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//Fin class