import java.io.*;
import java.util.Scanner;

public class var12 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try {
            Scanner sc = new Scanner(System.in);
            File f1 = new File("C:\\Users\\Наталья\\IdeaProjects\\lab7\\src\\nnn.txt");
            f1.createNewFile();
            fos = new FileOutputStream(f1);
            oos = new ObjectOutputStream(fos);
            System.out.println("Сколько рек:");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++){
                Rivers rivers = new Rivers();
                System.out.println("Название реки");
                rivers.name = sc.nextLine();
                System.out.println("Место расположения реки:");
                rivers.region = sc.nextLine();
                System.out.println("Длина реки:");
                rivers.longitude = sc.nextInt();
                sc.nextLine();
                oos.writeObject(rivers);
            }
            fis = new FileInputStream(f1);
            oin = new ObjectInputStream(fis);
            Rivers r = null;
            int max = 0;
            Object maxInfo = null;
            for (int i = 0; i < count; i++) {
                r = (Rivers) oin.readObject();
                if (r.longitude>max){
                    max=r.longitude;
                    maxInfo=r;
                }
            }
            System.out.println("Информация о самой длинной реке: "+maxInfo);
            oos.writeObject(maxInfo);
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            oin.close();
            fis.close();
        }
    }
}