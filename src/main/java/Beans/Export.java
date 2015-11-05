/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Peter
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

 

import net.sf.jasperreports.engine.JRException;


import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperExportManager;

import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;
@ManagedBean(name = "Export")
@SessionScoped

public class Export{

public void PDF() throws JRException, ClassNotFoundException, SQLException
    {        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Expenses","root","");
        
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        jasperReport = JasperCompileManager.compileReport("C:\\Users\\peter pc\\Documents\\NetBeansProjects\\Df\\web\\Reports\\report1.jrxml");
        jasperPrint = JasperFillManager.fillReport(
        jasperReport, new HashMap(), conect);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\peter pc\\Desktop\\report.pdf");
    }
}