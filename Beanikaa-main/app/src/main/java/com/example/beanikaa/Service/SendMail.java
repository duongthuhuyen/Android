package com.example.beanikaa.Service;

import android.content.Context;

import com.example.beanikaa.Service.Mail.JavaMailAPI;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class SendMail {
        private Context context;
        private String to;

        private String subject;
        private String message;

    public SendMail(Context context, String to, String subject, String message) {
        this.context = context;
        this.to = to;

        this.subject = subject;
        this.message = message;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }



    public void send(){
        JavaMailAPI javaMailAPI = new JavaMailAPI(context,to,subject,message);
        javaMailAPI.execute();

    }
}

