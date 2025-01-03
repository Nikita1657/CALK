import javax.swing.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner calk2 = new Scanner(System.in);
        String calk = calk2.nextLine();
        char action;
        String[] data;
        if (calk.contains(" + ")) {
            data = calk.split(" \\+ ");
            action = '+';
        } else if (calk.contains(" - ")) {
            data = calk.split(" - ");
            action = '-';
        } else if (calk.contains(" * ")) {
            data = calk.split(" \\* ");
            action = '*';
        } else if (calk.contains(" / ")) {
            data = calk.split(" / ");
            action = '/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
            if (data[0].length() > 10) {
                throw new Exception("программа принимает строки до 10 символов");
            }
        if (data[0].contains("\"")) {
        }  else{
            new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if (multiplier == 0) {
                throw new Exception("делить на 0 нельзя");
            }

            if (multiplier < 1 || multiplier > 10) {
                throw new Exception("Число для умножения должно быть от 1 до 10");
            }


            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
                if (result.length() > 40) {
                    String rez = result.substring(0, 40);
                    System.out.println(rez + "...");

                } else {
                    System.out.println(result);

            }


        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
}