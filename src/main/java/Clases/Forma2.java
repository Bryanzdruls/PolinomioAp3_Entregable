package Clases;

import javax.swing.JOptionPane;

public class Forma2 {
    //Atributos.
    private int Vpf2 [], Du, n;
    
     //metodos.
    public Forma2(int tam)//Constructor 
    {
        n = tam;
        Du=n-1;
        Vpf2 = new int[n];               
        
    }
    public Forma2()//Sobrecarga de Constructor 
    {
        Du=n-1;
        Vpf2 = new int[n];                     
    } 

    public int[] getVpf2() {
        return Vpf2;
    }

    public int getDu() {
        return Du;
    }

    public int getN() {
        return n;
    }

    public void setVpf2(int[] Vpf1) {
        this.Vpf2 = Vpf1;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public int getVpf2(int pos) {
        return Vpf2[pos];
    }
    
    public void setVpf2(int pos, int d) {
        Vpf2[pos] = d;
    }
    
    public Forma2 convertirForma2(String Vs[], Forma2 a, int n)
    {
        int i=0, j=0,s=0, k=1;
        int aux[]=new int [n*2];
        System.out.println("tamaño del vs: " + Vs.length);
        System.out.println("tamaño del aux: "+ aux.length);
        int exp[]=new int [aux.length/2];
        System.out.println("numero de terminos es: "+n);
        a.setVpf2(0, n);
        for(j=0;Vs[i]!=null;j++){
            aux[j]=Integer.parseInt(Vs[i]);
            i++;
        }
        i=1; j=0;
        while(i<aux.length)
        {
            exp[j]=aux[i];
            j++;
            i=i+2;
        }
        i=0; j=0;
        for (i=0; i<aux.length; i++) //se ordena el vector aux
        {
            for (j=i+1; j<exp.length; j++)
            {
             if(exp[i]<exp[j])
             {
                s= exp[i];
                exp[i] = exp[j];
                exp[j] = s;
             }
           }
        }
        i=0;j=1;
        while(i<exp.length)
        {
            if(exp[i] == aux[j])
            {
                a.setVpf2(k, aux[j-1]);
                a.setVpf2(k+1, aux[j]);
                k=k+2;
                i++;
            }
            j=j+2;
            if(j>aux.length)
            {
                j=1;
            }
        }
        return a;
    }
    
    public void evaluar(Forma2 a, int cont)
    {
        int resul=0, i=2, x=0;
        x=Integer.parseInt((JOptionPane.showInputDialog(null, "Ingrese un valor para x: ")));
        
        while(i<=cont+1)
        {
            resul=(int)(Math.pow(x, a.getVpf2(i)))*a.getVpf2(i-1)+resul;
            i=i+2;
        }
       
        System.out.println("El resultado es: ");
        System.out.print(resul);
    }//Fin evaluar 
  
    public Forma2 Ajustar(Forma2 a)
    {
        int cont=0, i=1;
        while(i<=a.Du && a.Vpf2[i]==0)
        {
            cont++;
            i++;       
        }
        while(i>=a.Du)
        {
            a.Vpf2[i-cont]=a.Vpf2[i];
            i++;    
        }
        a.Vpf2[0]=a.Vpf2[0]-cont;
        Du=a.Vpf2[0]+1;
        return a;
    }//Fin ajustar
    
    public void mostrar(Forma2 a)//Mostrar BUENO
    {      
        for (int i = 0; i <= a.getDu(); i++)
        {
            System.out.print("|" + a.getVpf2(i));
        }//Fin for     
    }//Fin mostrar
    
    public Forma2 sumar(Forma2 a, Forma2 b, Forma2 c, int cont, int cont2, int nTerminos, int nTerminos2)
    {
        int i=2, j=2, k=1;
       
        while(i<cont+1)
        {
            while(j<cont2+1)
            {
                if(a.getVpf2(i) == b.getVpf2(j))
                {
                    c.setVpf2(k, a.getVpf2(i-1) + b.getVpf2(j-1));
                    c.setVpf2(k, a.getVpf2(i));
                    i=i+2;
                    j=j+2;
                    k++;
                }
                else
                {
                   j=j+2;
                }
            }
            
        }
        
        return c;
    }
   
    public void reconstruir()
    {
            for (int i = 1; i < Vpf2.length-1; i+=2) 
            {
                if(Vpf2[i] != 0 )
                {  
                    if (Vpf2[i+1]==0) 
                    {
                        if (Vpf2[i]<0) 
                        {
                            System.out.print(Vpf2[i]);
                        }
                        else
                        {
                            if(i==1 && Vpf2[i]>=0)
                            {
                                System.out.print(Vpf2[i]);
                            }
                            else
                            {
                                System.out.print("+"+Vpf2[i]);
                            }
                        }
                    }
                    else
                    {
                        if(Vpf2[i+1] ==1 )
                        {
                            if (Vpf2[i]<0) 
                            {
                                System.out.print(Vpf2[i]+"x");
                            }
                            else
                            {   
                                System.out.print("+"+Vpf2[i]+"x");
                            }
                        }
                        else
                        {
                            if(Vpf2[i+1]<0)
                            {
                                System.out.print(Vpf2[i]+"x"+"^"+Vpf2[i+1]);
                            }
                            else
                            {
                                if(i==1 && Vpf2[i]>0)
                                {
                                    System.out.print(Vpf2[i]+"x"+"^"+Vpf2[i+1]);
                                }
                                else
                                {
                                    if(i==1 && Vpf2[i]<0)
                                    {    
                                        System.out.print(Vpf2[i]+"x"+"^"+Vpf2[i+1]);
                                    }
                                    else
                                    {
                                        System.out.print("+"+Vpf2[i]+"x"+"^"+Vpf2[i+1]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.setVpf2(Vpf2);
    }//fin reconstruir
    public Forma2 insertarF2(Forma2 a, int exp, int coe)//BUENO falta exp<vector
    {
        int i=2, auxN=0;
        auxN=a.getN();
        a.setN(a.getN()+2);
        while(i<=a.getN())
        {
            if(a.getVpf2(i)== exp)
            {
                a.setVpf2(i-1, a.getVpf2(i-1)+coe);
                System.out.println("\nEl nuevo polinomio luego de insertar es: ");
                a.mostrar(a);
                return a;
            }
            else
            {
                if(a.getVpf2(i)>exp)
                {
             
                    i=i+2;
                }
                else
                {
                    a.setVpf2(0, a.getVpf2(0)+1);
                    Forma2 aux= new Forma2(a.getN());
                    aux.setVpf2(0, a.getVpf2(0));
                    aux.setVpf2(1, coe);
                    aux.setVpf2(2, exp);
                    int j=3, k=2;
                    i=1;
                    while(i<auxN)
                    {
                        aux.setVpf2(j, a.getVpf2(i));
                        i++;
                        j++;
                    }
                    //ordenar el vector cuando sucede este caso
                    /*i=1; j=0;
                    int aux2[]=new int [aux.getN()-1];
                    while(i<=aux.getN())
                    {
                        aux2[j] = aux.getVpf2(i);
                        j++;
                    }
                    int temp=0, s=aux.getN()-1, expo[]=new int [s/2];
                    i=2; j=0;
                    while(i<=aux.getN()) //lleno el vector con los exponentes del polinomio
                    {
                        expo[j]=aux.getVpf2(i);
                        j++;
                        i=i+2;
                    }
                    i=0; j=0;
                    for (i=0; i<aux.getN(); i++) //se ordena el vector con exponentes
                    {
                        for (j=i+1; j<expo.length; j++)
                        {
                         if(expo[i]<expo[j])
                         {
                            s= expo[i];
                            expo[i] = expo[j];
                            expo[j] = s;
                         }
                       }
                    }
                    i=0;j=1;
                    while(i<expo.length)
                    {
                        if(expo[i] == aux.getVpf2(j))
                        {
                            aux.setVpf2(k, aux2[j-1]);
                            a.setVpf2(k+1, aux2[j]);
                            k=k+2;
                            i++;
                        }
                        j=j+2;
                        if(j>aux.getN())
                        {
                            j=1;
                        }
                    }*/
                     System.out.println("\nEl nuevo polinomio luego de insertar es: ");
                     aux.mostrar(aux);
                     return aux;
                }
            }
        }
        return a;
    }//Insertar forma 2
}//Fin class