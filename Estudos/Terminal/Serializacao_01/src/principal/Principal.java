package principal;

import dominio.Pokemon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
    
    public static void main(String[] args) {
        
        Pokemon p1 = new Pokemon("Pikachu", "Elétrico", 60, 500, 1, true);

        try {
            FileOutputStream serialPok = new FileOutputStream("src/serialData/pokemon3.sdp");
            ObjectOutputStream objSer = new ObjectOutputStream(serialPok);

            objSer.writeObject(p1);
            
            objSer.close();
            serialPok.close();
            
            System.out.println(p1.toString());
            System.out.println("Pokemon serilizado!");
            
            p1 = new Pokemon("", "", 0, 0, 0, false);
            
            FileInputStream fis = new FileInputStream("src/serialData/pokemon1.sdp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            p1 = (Pokemon) ois.readObject();
            
            System.out.println(p1.toString());
            System.out.println("Pokemon deserializado!");
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }
}
