/**
 * Created by DunaevKA on 22.05.2017.
 */
public class YvSy {
    public static double[] Nomera = null;
    public static double[][] YV(double[][] Matr, boolean[] MaxMin){
        double max = 0;
        double min = 0;
        MaxMin = new boolean[]{false,true};//true если минимизируем
        double[][] MatrNorm = new double[Matr.length][Matr[0].length];

        for(int j=0;j<Matr.length;j++){
            MatrNorm[j][0] = Matr[j][0];
        }

        for(int i=1;i<Matr[0].length;i++){
            max = Matr[0][i];
            min = Matr[0][i];
            for(int j=0;j<Matr.length;j++){
                if(Matr[j][i]>max){
                    max = Matr[j][i];
                }
                if(Matr[j][i]<min){
                    min = Matr[j][i];
                }
            }
            //Нормируем
            if(MaxMin[i-1]){
                for(int j=0;j<Matr.length;j++){
                    MatrNorm[j][i] = (Matr[j][i] - min)/(max - min);
                }
            }else{
                for(int j=0;j<Matr.length;j++){
                    MatrNorm[j][i] = (Matr[j][i] - max)/(min - max);
                }
            }
        }
        //Ищем минимальное в столбцах нормированной матрицы отличное от нуля
        min=0;
        double ij = 0;
        min=MatrNorm[0][1];
        for(int i=1;i<MatrNorm[0].length;i++){
            for(int j=0;j<MatrNorm.length;j++){
                if(MatrNorm[j][i]<min&MatrNorm[j][i]>0){
                    min = MatrNorm[j][i];
                    ij = i;
                }
            }
        }
        //Если ij не первый столбец - меняем местами
        if(ij!=1){
            for(int j=0;j<Matr.length;j++){
                double buf = MatrNorm[j][1];
                MatrNorm[j][1] = MatrNorm[j][2];
                MatrNorm[j][2] = buf;
            }
        }
        //По этому столбцу ij будем сортировать, он будет слева
        boolean flag = true;
        //Метод пузырька по столбцу 1
        while (flag == true){
            flag = false;
            for (int j = 0; j < MatrNorm.length-1; j++) {
                if (MatrNorm[j][1] > MatrNorm[j + 1][1]) {
                    for(int k=0;k<MatrNorm[0].length;k++){
                        double t = MatrNorm[j][k];
                        MatrNorm[j][k] = MatrNorm[j + 1][k];
                        MatrNorm[j + 1][k] = t;
                    }
                    flag = true;
                }
            }
        }
        Nomera = new double[MatrNorm.length];
        for(int j = 0; j < MatrNorm.length; j++){
            Nomera[j] = MatrNorm[j][0];
        }
        //Считаем рейтинг
        double[][] Matrcd = new double[MatrNorm.length][2];
        for(int i = 0; i < MatrNorm.length-1; i++){
            Matrcd[i][0] = MatrNorm[i+1][1]/MatrNorm[i][2];
            if(Matrcd[i][0]>1){
                Matrcd[i][0] = 0;
            }
            Matrcd[i+1][1] = MatrNorm[i][2]/MatrNorm[i+1][1];
            if(Matrcd[i+1][1]>1){
                Matrcd[i+1][1] = 0;
            }
        }
        //Находим Минимум в столбцах новой таблицы. Дальше по формуле для макса (1/знач)*знач-min
        for(int i = 0; i < Matrcd[0].length; i++){
            //Минимум первый
            for(int j = 0; j < Matrcd.length; j++){
                if(Matrcd[j][i]!=0){
                    min = Matrcd[j][i];
                    break;
                }
            }
            int ii = 0;
            //Минимум во всём столбце
            for(int j = 0; j < Matrcd.length; j++){
                if(Matrcd[j][i]<min&Matrcd[j][i]!=0){
                    min = Matrcd[j][i];
                    ii = j;
                }
            }
            //Ищем максимум
            for(int j = 0; j < Matrcd.length; j++){
                if(Matrcd[j][i]!=0&j!=ii){
                    //max
                    Matrcd[j][i] = (1/Matrcd[j][i])*Matrcd[j][i]-min;
                    ii = j;
                    break;
                }
            }
            for(int j = 0; j < Matrcd.length; j++){
                if(Matrcd[j][i]!=0&j!=ii&Matrcd[j][i]!=min){
                    //остальные
                    Matrcd[j][i] = (Matrcd[j][i]- min)/(Matrcd[ii][i] - min);
                    //Matrcd[j][i] = 1-Matrcd[ii][i];
                }
            }
        }
//        System.out.println("Номер "+"Результаты");
//        for(int j = 0; j < Matrcd.length; j++){
//            if(Matrcd[j][0]!=0){
//                System.out.println(MatrNorm[j][0]+"   "+Matrcd[j][0]*100/2);
//            }else  if((Matrcd[j][1]!=0)){
//                System.out.println(MatrNorm[j][0]+"   "+Matrcd[j][1]*100/2);
//            }
//        }
//        System.out.println("Важен первый критерий");
//        System.out.println("Номер "+"Результаты");
//        for(int j = 0; j < Matrcd.length; j++){
//            if(Matrcd[j][0]!=0){
//                System.out.println(MatrNorm[j][0]+"   "+Matrcd[j][0]*100);
//            }
//        }
//        System.out.println("Важен второй критерий");
//        System.out.println("Номер "+"Результаты");
//        for(int j = 0; j < Matrcd.length; j++){
//            if((Matrcd[j][1]!=0)){
//                System.out.println(MatrNorm[j][0]+"   "+Matrcd[j][1]*100);
//            }
//        }
        return Matrcd;
    }

    public static double[] GetNom(){
        return Nomera;
    }
}
