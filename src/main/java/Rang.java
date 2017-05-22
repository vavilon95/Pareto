import com.intellij.uiDesigner.core.GridConstraints;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DunaevKA on 30.03.2017.
 */
public class Rang {
    private JPanel root2;
    private JTextField textField1;
    private JButton создатьButton;
    private JPanel TablEcsp;
    private JButton расчётВесовButton;
    private JFrame Par2 = new JFrame();
    public Integer krit = 0;
    private JTable Table = new JTable();
    private JPanel Pan1 = new JPanel();
    private  JFrame Frame = new JFrame();
    public static JTable Vesa;
    public Rang() {
        создатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TablEcsp.removeAll();
                Object[] columnsHeader = new Object[krit+1];//{"Имя файла","Путь к файлу"}
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
                    Object[] O = new Object[Integer.parseInt(textField1.getText())+1];
                    O[0] = i;
                    model.addRow(O);
                }
                Table = new JTable(model);
                JScrollPane SPOne = new JScrollPane(Table);
                SPOne.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                GridConstraints c = new GridConstraints();
                c.setFill(3);
                TablEcsp.add(SPOne, c);

                Other.Kost(Par2);
            }
        });
        расчётВесовButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[][] Data = new double[Integer.parseInt(textField1.getText())][krit+1];
                for(int i=0;i<Integer.parseInt(textField1.getText());i++){
                    for(int j=0;j<krit+1;j++){
                        Data[i][j] = Double.parseDouble(String.valueOf(Table.getValueAt(i,j)));
                    }
                }
                double[] Vect = new double[Data[0].length-1];
                for(int i=1;i<Data[0].length;i++){
                    double sum = 0;
                    for(int j=0;j<Data.length;j++){
                        sum = sum+Data[j][i];
                    }
                    Vect[i-1] = sum;
                }
                double VectSum = 0;
                for(int i =0;i<Vect.length;i++){
                    VectSum = VectSum + Vect[i];
                }

                Pan1.removeAll();
                Object[] columnsHeader2 = new Object[krit+1];//{"Имя файла","Путь к файлу"}
                columnsHeader2[0]="Vesa";
                DefaultTableModel model2= new DefaultTableModel();
                // Определение стоблцов
                model2.setColumnIdentifiers(columnsHeader2);
                // Наполнение модели данными
                while (model2.getRowCount()>0) {
                    model2.removeRow(0);
                }
                //Вывод в таблицу
                Object[] O = new Object[krit+1];
                O[0] = "Vesa";
                for(int i=0;i<Vect.length;i++){
                    O[i+1] = Vect[i]/VectSum;
                }
                model2.addRow(O);


                //Вывод в таблицу
                //for(int i=0;i<Integer.parseInt(textField1.getText());i++){

//               // }
                Vesa = new JTable(model2);
                JScrollPane SPOne2 = new JScrollPane(Vesa);
                SPOne2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                SPOne2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                GridConstraints c = new GridConstraints();
                c = new GridConstraints();
                c.setFill(3);
                Pan1.add(SPOne2, c);
                //Other.Kost(Par);
                Other.Kost(Frame);
                Par2.dispose();
            }
        });
    }

    public void Rang(int krit, JPanel Pan1, JFrame Frame){
        this.Frame = Frame;
        this.Pan1=Pan1;
        this.krit = krit;
        Other.frameDisplayCenter(500,500,Par2);
        Par2.setContentPane(root2);
        Par2.setVisible(true);

    }

    public static JTable retTab(){
        return Vesa;
    }
}
