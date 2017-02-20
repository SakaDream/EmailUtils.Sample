/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.lib.email.sample;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Profile;
import com.sakadream.lib.email.gmail.auth.GmailAuthorize;
import com.sakadream.lib.email.gmail.utils.Misc;
import com.sakadream.lib.email.gmail.utils.SendEmail;
import java.util.Scanner;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Phan Ba Hai
 */
public class EmailUtilsSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("com.sakadream.lib.email.sample program");
        System.out.print("To: ");
        String to = sc.nextLine();
        System.out.print("Subject: ");
        String subject = sc.nextLine();
        System.out.print("Body: ");
        String body = sc.nextLine();
        
        System.out.println("-------------------------------------------------");
        System.out.println("Initialize GMail Service, please check the openning browser window...");
        Gmail service = GmailAuthorize.getGmailService();
        
        MimeMessage message = SendEmail.createEmail(Misc.getUserEmailAddress(service, "me"), to, subject, body);
        SendEmail.sendMessage(service, "me", message);
    }
}
