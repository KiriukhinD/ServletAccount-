package org.example.webapps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFileWrite {
   public static void main(String [] args){
       List<NewAccount> accountList = new ArrayList<>();
       try{
           NewAccount gg = new NewAccount("Derek","12345676");
           NewAccount gg1 = new NewAccount("Ben","67821345");
           NewAccount gg2 = new NewAccount("Lindsy","24242224");
           NewAccount gg3 = new NewAccount("Gabriel","363355");

           accountList.add(gg);
           accountList.add(gg1);
           accountList.add(gg2);
           accountList.add(gg3);

           File file = new File("C:\\Users\\My\\Desktop\\Foo.txt");
           BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(file)));

           for(NewAccount str:accountList) {
                  bufferedWriter.write(str +System.lineSeparator());
               bufferedWriter.write(str.getName() + "/");
               bufferedWriter.write(str.getBankAccount() + "\n");
               System.out.println(str);
           }
               bufferedWriter.close();


       }catch (IOException exp){
           exp.printStackTrace();
       }
   }


}
