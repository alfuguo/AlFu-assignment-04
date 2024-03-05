package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentListApp {
    public static void main(String[] args) throws IOException {
    	Students[] students = new Students[100];
    	int i = 0;
    	String line;
    	
    	try  (BufferedReader fileReader = new BufferedReader(new FileReader("student-master-list.csv"))) {
            	String header = fileReader.readLine();
	           
	
	            // Write a header to each file:
	            FileWriter compsciWriter = new FileWriter("course1.csv");
	            FileWriter apmthWriter = new FileWriter("course2.csv");
	            FileWriter statWriter = new FileWriter("course3.csv");
	
	            compsciWriter.write(header + "\n");
	            apmthWriter.write(header + "\n");
	            statWriter.write(header + "\n");
	
	            while ((line = fileReader.readLine()) != null) {
	                String[] columns = line.split(",");
	                int studentID = Integer.parseInt(columns[0]);
	                String studentName = columns[1];
	                String course = columns[2].trim();
	                int grade = Integer.parseInt(columns[3]);
	                students[i] = new Students(studentID, studentName, course, grade);
	                i++;
	            }
	
	            
	            for (int pass = 0; pass < students.length - 1; pass++) {
	                for (int j = 0; j < students.length - 1 - pass; j++) {
	                    if (students[j].getGrade() < students[j + 1].getGrade()) {
	                        	Students temp = students[j];
	                        	students[j] = students[j + 1];
	                        	students[j + 1] = temp;
	                    }
	                }
	            }
	
	      
	            for (Students student : students) {
	                String lineToWrite = student.getId() + "," +
	                                     student.getName() + "," +
	                                     student.getCourse() + "," +
	                                     student.getGrade() + "\n";
	
	                if (student.getCourse().startsWith("COMP")) {
	                    compsciWriter.write(lineToWrite);
	                } else if (student.getCourse().startsWith("APMTH")) {
	                    apmthWriter.write(lineToWrite);
	                } else if (student.getCourse().startsWith("STAT")) {
	                    statWriter.write(lineToWrite);
	                }
	            }
	
	            compsciWriter.close();
	            apmthWriter.close();
	            statWriter.close();
	            
       } catch (IOException e) {
        e.printStackTrace();
       	}
	    }
	}
