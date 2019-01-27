package com.praveen.data.applications;

import org.hibernate.Session;

import com.praveen.data.utilities.HibernateUtil;

public class AppUsingXML {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
    }
}