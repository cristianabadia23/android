package info.palomatica.primosapp;
public class NPrimo {
    int fin;
    public NPrimo(int fin) {
        this.fin = fin;
    }
    public int generarPrimo(){
        int result = 0;
        //int cont=0;
        for (int i = 2,cont=0; cont < this.fin ; i++) {
            if (isPrime(i)){
                result=i;
                cont++;
            }

        }
        return result;
    }
    public boolean isPrime(int num){
        int cont=0;
        for (int i = 2; i <=num/2 ; i++) {
            if (num%i == 0){
                cont++;
            }
        }
        if (cont==0){
            return true;
        }
        return false;
    }
}