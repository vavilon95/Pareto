import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DunaevKA on 16.03.2017.
 */
public class Par{
    private JPanel root;
    private JTextField textField1;
    private JTextField textField2;
    private JButton создатьButton;
    private JPanel Panel2;
    private JPanel Pan2;
    private JButton считатьButton;
    private JPanel Pan3;
    private JButton ранжироватьButton;
    private JButton методУверенныхСужденийButton;
    public static JTable Table2 = new JTable();
    public static JTable Table = new JTable();
    public  static JTable Table22 =null;
    public Par(){

        JFrame Par = new JFrame();
        Par.setContentPane(root);
        Other.frameDisplayCenter(500,610,Par);
        Par.setVisible(true);
        Par.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Создаем таблицу
        создатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel2.removeAll();
                Object[] columnsHeader = new Object[Integer.parseInt(textField2.getText())+1];//{"Имя файла","Путь к файлу"}
                columnsHeader[0]="ID";
                DefaultTableModel model= new DefaultTableModel();
                // Определение стоблцов
                model.setColumnIdentifiers(columnsHeader);
                // Наполнение модели данными
                while (model.getRowCount()>0) {
                    model.removeRow(0);
                }
                //Вывод в таблицу
//                double[][] Data = new double[][]{{1,2,3},
//                        {3,2,2},
//                        {2,3,1}};
                for(int i=0;i<Integer.parseInt(textField1.getText());i++){
                    Object[] O = new Object[Integer.parseInt(textField2.getText())+1];
                    O[0] = i;
//                    O[1] = Data[i][0];
//                    O[2] = Data[i][1];
//                    O[3] = Data[i][2];
                    model.addRow(O);
                }
                Table = new JTable(model);
                JScrollPane SPOne = new JScrollPane(Table);
                SPOne.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                GridConstraints c = new GridConstraints();
                c.setFill(3);
                Panel2.add(SPOne, c);


                Pan2.removeAll();
                Object[] ModO = new Object[Integer.parseInt(textField2.getText())+1];
                Object[][] Mod = new Object[1][Integer.parseInt(textField2.getText())+1];
                Class [] ClasC = new Class [Integer.parseInt(textField2.getText())+1];
                ClasC[0] =  java.lang.String.class;
                Mod[0][0] = "max/min";
                ModO[0] = "max/min";
                ClasC[1] =  java.lang.String.class;
                for(int i=1;i<Integer.parseInt(textField2.getText())+1;i++){
                    Mod[0][i] = new Boolean(true);
                    ModO[i] = "CheckBox";
                    ClasC[i] =  java.lang.Boolean.class;
                }
                Table2 = new JTable();
                Table2.setModel(new javax.swing.table.DefaultTableModel(
                        Mod,ModO
                ) {
                    Class[] types = ClasC;
                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
                });
                JScrollPane SPOne2 = new JScrollPane(Table2);
                SPOne2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                c = new GridConstraints();
                c.setFill(3);
                Pan2.add(SPOne2, c);

//
                Pan3.removeAll();
                Object[] columnsHeader2 = new Object[Integer.parseInt(textField2.getText())+1];//{"Имя файла","Путь к файлу"}
                columnsHeader2[0]="Vesa";
                DefaultTableModel model2= new DefaultTableModel();
                // Определение стоблцов
                model2.setColumnIdentifiers(columnsHeader2);
                // Наполнение модели данными
                while (model2.getRowCount()>0) {
                    model2.removeRow(0);
                }
                //Вывод в таблицу
                //for(int i=0;i<Integer.parseInt(textField1.getText());i++){
                Object[] O = new Object[Integer.parseInt(textField2.getText())+1];
                O[0] = "Vesa";
                model2.addRow(O);
//               // }
                Table22 = new JTable(model2);
                JScrollPane SPOne22 = new JScrollPane(Table22);
                SPOne22.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne22.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                c = new GridConstraints();
                c.setFill(3);
                Pan3.add(SPOne22, c);
                //Other.Kost(Par);
                Other.Kost(Par);
            }
        });
        считатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[] MaxMin = new boolean[Integer.parseInt(textField2.getText())];
                double[] Vesa = new double[Integer.parseInt(textField2.getText())];
                double[][] Data = new double[Integer.parseInt(textField1.getText())][Integer.parseInt(textField2.getText())+1];
                double[][] DataBuf= new double[Integer.parseInt(textField1.getText())][Integer.parseInt(textField2.getText())+1];
                for(int i=1;i<Integer.parseInt(textField2.getText())+1;i++){
                    MaxMin[i-1] = (boolean)Table2.getValueAt(0,i);
                }
                if(Table22.getValueAt(0,1) == null){
                    Table22 = Rang.retTab();
                }
                for(int i=1;i<Integer.parseInt(textField2.getText())+1;i++){
                    Vesa[i-1] = Double.parseDouble(String.valueOf(Table22.getValueAt(0,i)));
                }
//                Data = new double[][]{{0,5,8,180},
//                                    {1,3,7,210},
//                                    {2,6,5,300},
//                                    {3,6,3,250},
//                                    {4,4,4,210},
//                                    {5,5,10,130},
//                                    {6,1,3,145},
//                                    {7,5,2,210}};
//                Data = new double[][]{{15,3,40},
//                        {30,6,60},
//                        {10,2,10},
//                        {20,4,25}};
//                DataBuf = new double[][]{{15,3,40},
//                        {30,6,60},
//                        {10,2,10},
//                        {20,4,25}};
//                double[][] DataBuf = new double[][]{{0,5,8,180},
//                        {1,3,7,210},
//                        {2,6,5,300},
//                        {3,6,3,250},
//                        {4,4,4,210},
//                        {5,5,10,130},
//                        {6,1,3,145},
//                        {7,5,2,210}};
//                Data = new double[][]{{0,5,8,4},
//
//                        {2,6,5,1},
//
//                        {5,5,10,6},
//                        };
                for(int i=0;i<Integer.parseInt(textField1.getText());i++){
                    for(int j=0;j<Integer.parseInt(textField2.getText())+1;j++){
                        Data[i][j] = Double.parseDouble(String.valueOf(Table.getValueAt(i,j)));
                        DataBuf[i][j] = Double.parseDouble(String.valueOf(Table.getValueAt(i,j)));
                    }
                }
                for(int i=0; i<MaxMin.length;i++){
                    if(MaxMin[i]==false){
                        Data = Matrix.InvStolb(Data,i+1);

                    }
                }
                boolean f = true;
                double[][] newData = null;
                while (f){
                    newData = Matrix.Pareto(Data);
                    if(newData==null){
                        f = false;
                        newData = Data;
                    }else{
                        if((newData.length==Data.length)|(newData.length==0)){
                            f = false;
                            newData = Data;
                        }else{
                            Data = newData;
                        }
                    }

                }
                for(int i=0; i<MaxMin.length;i++){
                    if(MaxMin[i]==false){
                        newData = Matrix.InvStolbPl(DataBuf,newData, i+1);
                    }
                }
                if(newData.length==0){
                    Mes.ErrorW("Невозможно построить множество Парето!");
                }else{
                    JFrame Rezult = new JFrame();
                    JPanel Pan = new JPanel();
                    Rezult.setTitle("Множество Парето");
                    Other.frameDisplayCenter(500,500,Rezult);
                    Object[] columnsHeader = new Object[newData[0].length];//{"Имя файла","Путь к файлу"}
                    columnsHeader[0]="ID";
                    DefaultTableModel model= new DefaultTableModel();
                    // Определение стоблцов
                    model.setColumnIdentifiers(columnsHeader);
                    // Наполнение модели данными
                    while (model.getRowCount()>0) {
                        model.removeRow(0);
                    }
                    //Вывод в таблицу
                    for(int i=0;i<newData.length;i++){
                        Object[] O = new Object[newData[0].length];
                        int j=0;
                        for(double D:newData[i]){
                            O[j] = D;
                            j++;
                        }
                        model.addRow(O);
                    }
                    JTable Tab = new JTable(model);

                    JScrollPane SPOne = new JScrollPane(Tab);
                    SPOne.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    SPOne.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    GridConstraints c = new GridConstraints();
                    c.setFill(3);
                    Pan.add(SPOne, c);
                    Rezult.setContentPane(Pan);
                    Rezult.setVisible(true);

                    double[][] MatrVes = new double[newData.length][newData[0].length+1];
                    for(int i=0;i<MatrVes.length;i++){
                        MatrVes[i][0]=newData[i][0];
                    }
                    //Расчёт с весами
                    for(int i=1;i<newData[0].length;i++){

                        double max = newData[0][i];
                        double min = newData[0][i];
                        for(int j=1;j<newData.length;j++){
                            if(newData[j][i]>max){
                                max = newData[j][i];
                            }
                            if(newData[j][i]<min){
                                min = newData[j][i];
                            }
                        }
                        if(MaxMin[i-1]==true){
                            for(int j=0;j<newData.length;j++){
                                double d = newData[j][i];
                                if(max-min==0){
                                    MatrVes[j][i] = 1;
                                }else{
                                    MatrVes[j][i] = (newData[j][i] - min)/(max - min);
                                }

                            }
                        }else{
                            for(int j=0;j<newData.length;j++){
                                MatrVes[j][i] = (max - newData[j][i])/(max - min);
                            }
                        }
                    }

                    for(int i=0;i<MatrVes.length;i++){
                        double sum = 0;
                        for(int j=1;j<MatrVes[0].length-1;j++){
                            sum = sum + MatrVes[i][j]*Vesa[j-1];
                        }
                        MatrVes[i][MatrVes[0].length-1] = sum;
                    }
                    //Свёртка Гермейра
                    double[][] MatrVes2 = new double[MatrVes.length][MatrVes[0].length+1];
                    for(int i=0;i<MatrVes.length;i++){
                        for(int ii=0;ii<MatrVes[0].length;ii++){
                            MatrVes2[i][ii]=MatrVes[i][ii];
                        }
                    }
                    for(int i=0;i<MatrVes2.length;i++){
                        double max = MatrVes2[i][1]*Vesa[0];
                        for(int j=2; j<MatrVes2[0].length-2;j++){
                            if(MatrVes2[i][j]*Vesa[j-1]>max){
                                max = MatrVes2[i][j]*Vesa[j-1];
                            }
                        }
                        MatrVes2[i][MatrVes2[0].length-1] = max;
                    }
                    JFrame Rezult2 = new JFrame();
                    JPanel Pan2 = new JPanel();
                    Rezult2.setTitle("Матрица на основе весов");
                    Other.frameDisplayCenter(500,500,Rezult2);
                    Object[] columnsHeader2 = new Object[3];//{"Имя файла","Путь к файлу"}
                    columnsHeader2[0]="ID";
                    columnsHeader2[columnsHeader2.length-1]="Wger";
                    columnsHeader2[columnsHeader2.length-2]="Wlin";
                    DefaultTableModel model2= new DefaultTableModel();
                    // Определение стоблцов
                    model2.setColumnIdentifiers(columnsHeader2);
                    // Наполнение модели данными
                    while (model2.getRowCount()>0) {
                        model2.removeRow(0);
                    }
                    //Вывод в таблицу
                    for(int i=0;i<MatrVes2.length;i++){
                        Object[] O = new Object[MatrVes2[0].length];
                        O[0]=MatrVes2[i][0];
                        O[1]=MatrVes2[i][MatrVes2[0].length-2];
                        O[2]=MatrVes2[i][MatrVes2[0].length-1];
//                        int j=0;
//                        for(double D:MatrVes2[i]){
//                            O[j] = D;
//                            j++;
//                        }
                        model2.addRow(O);
                    }
                    JTable Tab2 = new JTable(model2);

                    JScrollPane SPOne2 = new JScrollPane(Tab2);
                    SPOne2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    SPOne2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    GridConstraints c2 = new GridConstraints();
                    c2.setFill(3);
                    Pan2.add(SPOne2, c2);
                    Rezult2.setContentPane(Pan2);
                    Rezult2.setVisible(true);
                }


            }
        });
        ранжироватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rang r = new Rang();
                r.Rang(Integer.parseInt(textField2.getText()),Pan3,Par);
            }
        });
        методУверенныхСужденийButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[] MaxMin = new boolean[Integer.parseInt(textField2.getText())];
                double[][] Data = new double[Integer.parseInt(textField1.getText())][Integer.parseInt(textField2.getText())+1];
                for(int i=1;i<Integer.parseInt(textField2.getText())+1;i++){
                    MaxMin[i-1] = (boolean)Table2.getValueAt(0,i);
                }
                for(int i=0;i<Integer.parseInt(textField1.getText());i++){
                    for(int j=0;j<Integer.parseInt(textField2.getText())+1;j++){
                        Data[i][j] = Double.parseDouble(String.valueOf(Table.getValueAt(i,j)));
                    }
                }
                /*double[][] Data = new double[][]{
                        {0,30,70},
                        {1,40,80},
                        {2,20,60},
                        {3,34,80}
                };*/
//                double[][] Data = new double[][]{
//                        {0,4,4},
//                        {1,7,20},
//                        {2,3,8},
//                        {3,5,15}
//                };
//                double[][] Data = new double[][]{
//                        {0,30,75},
//                        {1,40,100},
//                        {2,20,60},
//                        {3,35,80}
//                };
                //boolean[] MaxMin = new boolean[]{false,true};//true если минимизируем
                double[][] MatrRez = YvSy.YV(Data,MaxMin);
                double[] Nomera = YvSy.GetNom();
                JFrame Rezult3 = new JFrame();
                JPanel Pan3 = new JPanel();
                Rezult3.setTitle("Матрица на основе уверенных суждений");
                Other.frameDisplayCenter(500,500,Rezult3);
                Object[] columnsHeader3 = new Object[4];//{"Имя файла","Путь к файлу"}
                columnsHeader3[0]="ID";
                columnsHeader3[1]="Результаты";
                columnsHeader3[2]="Важен первый";
                columnsHeader3[3]="Важен второй";
                DefaultTableModel model2= new DefaultTableModel();
                // Определение стоблцов
                model2.setColumnIdentifiers(columnsHeader3);
                // Наполнение модели данными
                while (model2.getRowCount()>0) {
                    model2.removeRow(0);
                }
                //Вывод в таблицу
                for(int i=0;i<Data.length;i++){
                    Object[] O = new Object[4];
                    O[0]=Nomera[i];
                    if(MatrRez[i][0]!=0){
                        O[1]=MatrRez[i][0]*100/2;
                    }else if(MatrRez[i][1]!=0){
                        O[1]=MatrRez[i][1]*100/2;
                    }else{
                        O[1]="";
                    }

                    if(MatrRez[i][0]!=0){
                        O[2]=MatrRez[i][0]*100;
                    }else{
                        O[2]="";
                    }
                    if(MatrRez[i][1]!=0){
                        O[3]=MatrRez[i][1]*100;
                    }else{
                        O[3]="";
                    }
                    model2.addRow(O);
                }
                JTable Tab3 = new JTable(model2);

                JScrollPane SPOne3 = new JScrollPane(Tab3);
                SPOne3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                GridConstraints c2 = new GridConstraints();
                c2.setFill(3);
                Pan3.add(SPOne3, c2);
                Rezult3.setContentPane(Pan3);
                Rezult3.setVisible(true);

            }
        });
    }
    public static void main(String[] args){
        Other.WebLFActiv();
        new Par();
    }
}
