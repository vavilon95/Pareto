import javax.swing.*;

/**
 * Created by DunaevKA on 23.03.2017.
 */
public class Mes {
    //Вывод сообщения об ошибке
    public static void ErrorW(String Text){
        JOptionPane.showMessageDialog(null, Text, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }
    public static void GoodW(String Text){
        JOptionPane.showMessageDialog(null, Text, "Готово!", JOptionPane.INFORMATION_MESSAGE);
    }
}
