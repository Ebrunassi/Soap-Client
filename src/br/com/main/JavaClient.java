
package br.com.main;
import org.apache.commons.codec.binary.Base64;

import java.net.URL;
import java.util.*;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.util.Scanner;

public class JavaClient {
   public static void main (String [] args) {
   
      try {
         XmlRpcClient client = new XmlRpcClient(); 
         XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
         config.setServerURL(new URL("http://localhost:8051/RPC2"));
         client.setConfig(config);
         
         Vector<Object> params = new Vector<Object>();
         
         
         params.addElement(new Integer(17));
         params.addElement(new Integer(13));
         params.addElement("oi");
//         Scanner input = new Scanner( System.in );
//         String nome = input.nextLine();
//         params.addElement(nome);
         
         Object result = client.execute("sample.sum", params);
         int sum = ((Integer) result).intValue();
         System.out.println("The sum is: "+ sum);
         
//         Object object = client.execute("sample.ola",params);
         
         
         

      } catch (Exception exception) {
         System.err.println("JavaClient: " + exception);
      }
   }
}