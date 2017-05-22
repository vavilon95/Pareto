import java.util.ArrayList;

/**
 * Created by DunaevKA on 23.03.2017.
 */
public class Matrix {
    public static double[][] InvStolb(double[][] Matr, int nomer){
        double max = Matr[0][nomer];
        for(int i=1;i<Matr.length;i++){
            if(Matr[i][nomer]>max){
                max = Matr[i][nomer];
            }
        }
        for(int i=0;i<Matr.length;i++){
            Matr[i][nomer] = max - Matr[i][nomer];
        }
        return Matr;
    }
    public static double[][] InvStolbPl(double[][] Matr, double[][] Matr2, int nomer){
        double max = Matr[0][nomer];
        for(int i=1;i<Matr.length;i++){
            if(Matr[i][nomer]>max){
                max = Matr[i][nomer];
            }
        }

        for(int i=0;i<Matr2.length;i++){
            Matr2[i][nomer] = max - Matr2[i][nomer];
        }
        return Matr2;
    }
    public static double[][] Pareto(double[][] Matr){
        ArrayList<Boolean> MassF = new ArrayList<>();
        ArrayList<Integer> Nomera= new ArrayList<>();
        double[][] Exit = null;
        boolean g = true;
        for(int i=0;i<Matr.length-1;i++){
            for(int j=i+1;j<Matr.length;j++){
                for(int k=1;k<Matr[0].length;k++){
                        if(Matr[i][k]>Matr[j][k]){
                            MassF.add(true);
                        }else if(Matr[i][k]==Matr[j][k]){

                        }else{
                            MassF.add(false);
                        }
                }
                if(MassF.size()!=0){
                    boolean h = true;
                    for(boolean f:MassF){
                        if(f == MassF.get(0)){
                            h = true;
                        }else{
                            h = false;
                            break;
                        }
                    }
                    if(h==true){
                        if(MassF.get(0)==true){
                            //Удаляем i+1
//                            System.out.println("Удаляем "+(j));
//                            System.out.println("оставляем "+(i));
                            Exit = remStr(Matr,j);
                            //Nomera.add(i);
                            g = false;
                            break;
                        }else{
                            //Удаляем i
//                            System.out.println("Удаляем "+i);
//                            System.out.println("оставляем "+(j));
                            Exit = remStr(Matr,i);
                            //Nomera.add(j);
                            g = false;
                            break;
                        }
                    }
                    MassF = new ArrayList<>();
                }
                if(g==false)break;
            }
            if(g==false)break;
        }
//        int y =0;
//        while(y!=Nomera.size()){
//            if(y<0)y=0;
//            int u = Nomera.get(y);
//            for(int h=y+1;h<Nomera.size();h++){
//                if(u == Nomera.get(h)){
//                    Nomera.remove(h);
//                    y--;
//                }
//            }
//            y++;
//        }
//
//        double[][] Exit = new double[Nomera.size()][Matr[0].length];
//        for(int i=0;i<Exit.length;i++){
//            for(int j=0;j<Exit[0].length;j++){
//                Exit[i][j] = Matr[Nomera.get(i)][j];
//            }
//        }
        return  Exit;
    }

    public static double[][] remStr(double[][] Matr, int Nomer){
        double[][] Ex = new double[Matr.length-1][Matr[0].length];
        int p=0;
        for(int i=0;i<Ex.length;i++){
            if(i==Nomer){
                p++;
                for(int j=0;j<Ex[0].length;j++){
                    Ex[i][j] = Matr[p][j];
                }
            }else{
                for(int j=0;j<Ex[0].length;j++){
                    Ex[i][j] = Matr[p][j];
                }
            }
            p++;

        }
        return Ex;
    }
}
