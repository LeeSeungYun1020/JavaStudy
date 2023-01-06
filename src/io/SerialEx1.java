package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "User.ser";
            FileOutputStream fos = new FileOutputStream("data" + File.separator + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream out = new ObjectOutputStream(bos);

            User u1 = new User("lee", "lee1234");
            User u2 = new User("park", "jung0000");
            ArrayList<User> list = new ArrayList<>(List.of(u1, u2));

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.writeObject(new SubTest());
            out.close();

            System.out.println("FINISH");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Test {
    String name = "name";
}

class SubTest extends Test implements Serializable {
    String sub = "sub";
    Other other;

    public SubTest() {
        other = new Other();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeObject(other.obj);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        other.obj = in.readObject();
        in.defaultReadObject();
    }
}

class Other {
    String oth = "other";
    Object obj = null;
}