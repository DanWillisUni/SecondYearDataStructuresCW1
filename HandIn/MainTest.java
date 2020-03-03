package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.CourseworkUtilities.generateDocument;

public class Main {

    public static void main(String[] args) {
        //runs all the tests
        TestOne();
        TestTwo();
        TestThree();
        TestFour();
        TestFive();
        TestSix();
        TestSeven();
        TestEight();
        TestNine();
        //averages all the tests
        String[][] FileNames = {{"FVBruteTestOne.csv","FVTreeTestOne.csv"},{"FVBruteTestTwo.csv","FVTreeTestTwo.csv"},{"FVBruteTestThree.csv","FVTreeTestThree.csv"},{"FVBruteTestFour.csv","FVTreeTestFour.csv"},{"DSDBruteTestFive.csv","DSDMineTestFive.csv"},{"DSDBruteTestSix.csv","DSDMineTestSix.csv"},{"DSDBruteTestSeven.csv","DSDMineTestSeven.csv"},{"DSDBruteTestEight.csv","DSDMineTestEight.csv"},{"DSDBruteTestNine.csv","DSDMineTestNine.csv"}};
        Average(FileNames);
    }
    //Tests
    private static void TestOne() {
        for (int i = 1000; i<=100000;i=i+100){
            for (int t = 0;t<5;t++) {
                try {
                    String[] Q = CourseworkUtilities.generateDictionary(1000,5);
                    String[] A = generateDocument(Q,i);
                    int[] Brute  = TestCalFV("Brute","A","TestOne",A,Q,t);
                    int[] Tree  = TestCalFV("Tree","A","TestOne",A,Q,t);
                    if (Comparison(Brute, Tree)!=-1){
                        System.out.println("Error: " + i + " Brute & Tree FV is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        System.out.println("TestOne Complete");
    }
    private static void TestTwo() {
        for (int i = 10; i<=1000;i=i+10){
            for(int t = 0;t<5;t++) {
                try {
                    String[] Q = CourseworkUtilities.generateDictionary(i, 5);
                    String[] A = generateDocument(Q,1000);
                    int[] Brute  = TestCalFV("Brute","Q","TestTwo",A,Q,t);
                    int[] Tree  = TestCalFV("Tree","Q","TestTwo",A,Q,t);
                    if (Comparison(Brute, Tree)!=-1){
                        System.out.println("Error: " + i + " Brute & Tree FV is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestTwo Complete");
    }
    private static void TestThree() {
        for (int i = 2; i<=1000;i++){
            for (int t = 0;t<5;t++){
                try {
                    String[] Q = CourseworkUtilities.generateDictionary(10,i);
                    String[] A = generateDocument(Q,100);
                    int[] Brute  = TestCalFV("Brute","w","TestThree",A,Q,t);
                    int[] Tree  = TestCalFV("Tree","w","TestThree",A,Q,t);
                    if (Comparison(Brute, Tree)!=-1){
                        System.out.println("Error: " + i + " Brute & Tree FV is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestThree Complete");
    }
    private static void TestFour() {
        for (int t = 0;t<5;t++){
            try {
                String[] Q = CourseworkUtilities.generateDictionary(10000,5);
                String[] A = generateDocument(Q,1000000);
                int[] Brute  = TestCalFV("Brute","N","TestFour",A,Q,t);
                int[] Tree  = TestCalFV("Tree","N","TestFour",A,Q,t);
                if (Comparison(Brute, Tree)!=-1){
                    System.out.println("Error: Brute & Tree FV is different");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("TestFour Complete");
    }
    private static void TestFive() {
        for (int i = 100;i<=10000;i=i+100){
            for (int t = 0;t<5;t++){
                try {
                    String [][] Docs = new String[10][i];
                    String[] Q = CourseworkUtilities.generateDictionary(100,5);
                    for (int o = 0; o<10;o++){
                        String[] A = generateDocument(Q,i);
                        Docs[o] = A;
                    }
                    int[] BruteDSD = TestCalfindNearestDocument("Brute","A","TestFive",Docs, Q, t);
                    int[] MineDSD = TestCalfindNearestDocument("Mine","A","TestFive",Docs, Q, t);
                    if (Comparison(BruteDSD, MineDSD)!=-1){
                        System.out.println("Error: " + i + " Brute & Mine DSD is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestFive Complete");
    }
    private static void TestSix() {
        for (int i = 100;i<=10000;i=i+100){
            for (int t = 0;t<5;t++){
                try {
                    String [][] Docs = new String[10][100];
                    String[] Q = CourseworkUtilities.generateDictionary(i,5);
                    for (int o = 0; o<10;o++){
                        String[] A = generateDocument(Q,100);
                        Docs[o] = A;
                    }
                    int[] BruteDSD = TestCalfindNearestDocument("Brute","Q","TestSix",Docs, Q, t);
                    int[] MineDSD = TestCalfindNearestDocument("Mine","Q","TestSix",Docs, Q, t);
                    if (Comparison(BruteDSD, MineDSD)!=-1){
                        System.out.println("Error: " + i + " Brute & Mine DSD is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestSix Complete");
    }
    private static void TestSeven() {
        for (int i = 2;i<=1000;i++){
            for (int t = 0;t<5;t++){
                try {
                    String [][] Docs = new String[10][100];
                    String[] Q = CourseworkUtilities.generateDictionary(10,i);
                    for (int o = 0; o<10;o++){
                        String[] A = generateDocument(Q,100);
                        Docs[o] = A;
                    }
                    int[] BruteDSD = TestCalfindNearestDocument("Brute","w","TestSeven",Docs, Q, t);
                    int[] MineDSD = TestCalfindNearestDocument("Mine","w","TestSeven",Docs, Q, t);
                    if (Comparison(BruteDSD, MineDSD)!=-1){
                        System.out.println("Error: " + i + " Brute & Mine DSD is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestSeven Complete");
    }
    private static void TestEight() {
        for (int i = 10;i<=1000;i=i+10){
            for (int t = 0;t<5;t++){
                try {
                    String [][] Docs = new String[i][100];
                    String[] Q = CourseworkUtilities.generateDictionary(10,5);
                    for (int o = 0; o<i;o++){
                        String[] A = generateDocument(Q,100);
                        Docs[o] = A;
                    }
                    int[] BruteDSD = TestCalfindNearestDocument("Brute","D","TestEight",Docs, Q, t);
                    int[] MineDSD = TestCalfindNearestDocument("Mine","D","TestEight",Docs, Q, t);
                    if (Comparison(BruteDSD, MineDSD)!=-1){
                        System.out.println("Error: " + i + " Brute & Mine DSD is different");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("TestEight Complete");
    }
    private static void TestNine() {
        for (int t = 0;t<5;t++){
            try {
                String [][] Docs = new String[10000][100];
                String[] Q = CourseworkUtilities.generateDictionary(10,5);
                for (int i = 0; i<10000;i++){
                    String[] A = generateDocument(Q,100);
                    Docs[i] = A;
                }
                int[] BruteDSD = TestCalfindNearestDocument("Brute","N","TestNine",Docs, Q, t);
                int[] MineDSD = TestCalfindNearestDocument("Mine","N","TestNine",Docs, Q, t);
                if (Comparison(BruteDSD, MineDSD)!=-1){
                    System.out.println("Error: Brute & Mine DSD is different");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("TestNine Complete");
    }
    //Calculating feature vector functions
    private static int[] calculateFeatureVectorTree(String[] A, String[] Q){
        //returns feature vector of given document A and dictionary Q using a tree
        int[] F = new int[Q.length];//initilises the array to return
        BinaryTree a = new BinaryTree();//creates the tree
        for (String word : A) {//for every word in the document
            a.add(word);//add the word to the tree
        }
        for (int s = 0;s<Q.length;s++){//for every word in dictionary
            F[s]=a.countNode(Q[s]);//feature vector array of that word = the word counted in the tree
        }
        return F;//return the feature vector array
    }
    private static int[] calculateFeatureVectorBrute(String[] A, String[] Q){
        //returns feature vector array F, given a document A and dictionary Q using brute force
        int[] F = new int[Q.length];//initilises the feature vector array
        for (int s = 0;s<Q.length;s++) {//for each word in dictionary
            int counter = 0;//set counter to 0
            for (int w = 0;w<A.length;w++) {//for every word in document
                if (Q[s].equals(A[w])){//if dictionary word equals the document word
                    counter++;//increment the counter
                }
            }
            F[s] = counter;//after checking every word in the document, add the counter to the feature vector array
        }
        return F;//return the feature vector array
    }
    private static int[] TestCalFV(String Algo,String Var,String FileName,String[] A,String[] Q,int t) {
        //tests the time the algorithem takes to compleate and writes in a csv file
        int[] F;//creates the new array for feature vectors
        long duration;
        if (Algo == "Brute"){//if the algorithem to be used is brute force
            long startTime = System.nanoTime();//start timer
            F = calculateFeatureVectorBrute(A, Q);//calculate feature vector using brute force
            long endTime = System.nanoTime();//end timer
            duration = (endTime - startTime); //duration = the time taken in ns
        } else { //else use tree
            long startTime = System.nanoTime();//start timer
            F = calculateFeatureVectorTree(A, Q);//calculate feature vectors using tree
            long endTime = System.nanoTime();//end timer
            duration = (endTime - startTime); //duration = time taken in ns
        }
        String NewFileName = "FV" + Algo + FileName + ".csv";//creates the file name string
        switch (Var) {//deciding which variable to print in the file
            case "A"://the document length
                csvAppend(NewFileName , t + "," + A.length + "," + duration + ",ns");//append to the csv file the results
                break;
            case "Q"://the dictionary length
                csvAppend(NewFileName, t + "," + Q.length + "," + duration + ",ns");//append to the csv file the results
                break;
            case "w"://the length of the words
                int l = A[0].length();//get the length of the words
                csvAppend(NewFileName, t + "," + l + "," + duration + ",ns");//append to the csv file the results
                break;
            case "N"://none
                csvAppend(NewFileName, t + "," + duration + ",ns");//append to the csv file the results
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Var);//unexpected value
        }
        return F;//return the featur vector array for comparison
    }
    //find the nearest document functions
    private static int calculateDSD(int[] A, int[] B){
        //calculates the Document similarity distance and returns it
        int DSD = 0;//sets the document similarity distance to 0
        for (int w =0;w<A.length;w++){//for every word in document
            DSD=DSD + Math.abs(A[w] - B[w]);//add the absolute value of documentA feature vector subtract documentB feature vector to document similarity
        }
        return DSD;//return document similarity distance
    }
    public static int[] findNearestDocumentsMine(String[][] Doc, String[] Q){
        int[] FND = new int[Doc.length];//initilise the find nearest document array
        int[][] distance = new int[Doc.length][Doc[0].length];//initilise the document
        int[][] F = new int[Doc.length][];//initilise the feature vector array
        for (int A = 0;A<Doc.length;A++){//for each document
            F[A] = calculateFeatureVectorTree(Doc[A],Q);//calculate the feature vector and populate F array
            for (int Ax = 0;Ax<Doc.length;Ax++){//for each docuemnt
                distance[A][Ax]=-1;//make the distance = -1
            }
            distance[A][A] = Integer.MAX_VALUE;//set each distance to itself to max value
        }
        for (int A = 0;A<Doc.length;A++){//for every document
            int currentBestDistance = Integer.MAX_VALUE;//set current best distance high
            int currentBestIndex = -1;//sets current best index to -1
            for (int Ax = A;Ax<Doc.length;Ax++){//for every document
                if(distance[A][Ax] == -1){//if untouched
                    distance[A][Ax] = calculateDSD(F[A],F[Ax]);//calculate distance
                    distance[Ax][A] = distance[A][Ax];//set mirror
                }
                if (distance[A][Ax] < currentBestDistance){//if the checked distance is less than the current best
                    currentBestIndex = Ax;//set the current best document
                    currentBestDistance = distance[A][Ax]; //set the current best distance
                }
            }
            FND[A] = currentBestIndex;//set the closest documents array
        }
        return FND;//return closest documents array
    }
    public static int[] findNearestDocumentsBrute(String[][] Doc, String[] Q){
        //finds the nearest document using brute force
        int[] FND = new int[Doc.length];//initilise the nearest document array
        for (int A = 0;A<Doc.length;A++){//for each document
            int closestIndex = -1;//set the closest index to -1
            int closestDif = Integer.MAX_VALUE;//set the closest difference to max value
            for (int Ax = 0;Ax<Doc.length;Ax++){//for each document
                if((Ax !=A) && (calculateDSD(calculateFeatureVectorTree(Doc[A],Q),calculateFeatureVectorTree(Doc[Ax],Q)) < closestDif)){//if the documents arent the same and the calculated document distances is less than the current closest document distance
                    closestDif = calculateDSD(calculateFeatureVectorTree(Doc[A],Q),calculateFeatureVectorTree(Doc[Ax],Q));//set the closest differance
                    closestIndex = Ax;//set the closest index
                }
            }
            FND[A] = closestIndex;//populate the nearest document array
        }
        return FND;//return the nearest document array
    }
    private static int[] TestCalfindNearestDocument(String Algo,String Var,String FileName,String[][] Docs,String[] Q,int t) {
        //tests the time and sends the time taken to a csv file
        int[] FND;//initilises the document distance array
        long duration;//initilises duration long
        if (Algo == "Brute"){//if the test is on the brute force algorithem
            long startTime = System.nanoTime();//start timer
            FND = findNearestDocumentsBrute(Docs,Q);//do the calculation using brute force
            long endTime = System.nanoTime();//end timer
            duration = (endTime - startTime);//set duration
        } else {//else
            long startTime = System.nanoTime();//start timer
            FND = findNearestDocumentsMine(Docs,Q);//use my algorithem to do the calculation
            long endTime = System.nanoTime();//end timer
            duration = (endTime - startTime); //set duration
        }
        String NewFileName = "DSD" + Algo + FileName + ".csv";//creates new filename as string
        switch (Var) {//figures out which variable to print along with the duration
            case "A"://doucment length
                csvAppend(NewFileName,  t + "," + Docs[0].length + "," + duration + ",ns");//appends to the csvfile
                break;
            case "Q" ://dictionary length
                csvAppend(NewFileName,  t + "," + Q.length + "," + duration + ",ns");//appends to the csvfile
                break;
            case "w" :
                int l = Docs[0][0].length();//word length
                csvAppend(NewFileName,  t + "," + l + "," + duration + ",ns");//appends to the csvfile
                break;
            case "D" ://document length
                csvAppend(NewFileName,  t + "," + Docs.length + "," + duration + ",ns");//appends to the csvfile
                break;
            case "N" ://none
                csvAppend(NewFileName,  t + "," + duration + ",ns");//appends to the csvfile
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Var);//unexpected value
        }
        return FND;//return the nearest document array for comparison
    }
    //File handling methods
    private static void Average(String[][] FileNames) {
        //averages all the files and puts them in one file
        for (int FileGroup = 0;FileGroup<FileNames.length;FileGroup++){//for each file group
            String[][] AllLines = new String[FileNames[FileGroup].length][];//initlise all the lines in all the files array
            for (int FileInGroup = 0;FileInGroup<FileNames[FileGroup].length;FileInGroup++){//for each file in the group
                String[] Lines = ReadFile(FileNames[FileGroup][FileInGroup]);//get all the lines
                AllLines[FileInGroup] = Lines;//set the lines in file into an array
            }
            String NewFileName = "Average";//initilise file name string
            for (int LineInFile = 0;LineInFile<AllLines[0].length;LineInFile++){//for every line//for every line
                String Line = "";//initilise line string
                for (int FileInGroup = 0;FileInGroup<AllLines.length;FileInGroup++){//for every file
                    if(LineInFile==0){//if its the first line
                        String[] FileSplit = FileNames[FileGroup][FileInGroup].split("\\.");//split the file into name and type
                        NewFileName=NewFileName+FileSplit[0];//add the name to the new file name
                    }
                    String[] Values = AllLines[FileInGroup][LineInFile].split(",");//split into cells
                    if(Values.length>1){//if there is actually data
                        if (Values[0].charAt(0)=='0'){//if it is the first iteration of it
                            if(Values.length==4 && FileInGroup==0){//add the variable number if necessary
                                Line=Line+Values[1] + ","; //getting the altered variable
                            }
                            long total = 0;//set total time to 0
                            for (int PlusLine = 0;PlusLine<5;PlusLine++){//for each line that is the same test
                                String[] PlusValue = AllLines[FileInGroup][LineInFile+PlusLine].split(",");//split the line
                                total=total+Long.parseLong(PlusValue[PlusValue.length - 2]);//get the duration and add it to the total
                            }
                            total=total/5;//total = the average
                            Line=Line+total+",";//add the total to the line string
                        }
                    }
                }
                if (Line != ""){//if the line is not empty
                    csvAppend(NewFileName+".csv",Line+"ns");//append to the csv file
                }
            }
        }
    }
    private static String[] ReadFile(String FileName){
        //reads the whole file and returns the lines in an array
        File file = new File(FileName);//makes the file
        List<String> lines = new ArrayList<String>();//makes the line arraylist
        BufferedReader in = null;//sets the buffer reader to null
        try {//try
            in = new BufferedReader(new FileReader(file));//make the buffer reader
            String inputLine;//create a string for the line to be put into
            while ((inputLine = in.readLine()) != null){//while the line isnt empty
                lines.add(inputLine);//add the line to the lines array list
            }
            in.close();//close the file
        } catch (FileNotFoundException e) {//catch for filenot found
            e.printStackTrace();//print error
        } catch (IOException e) {//catch for exception
            e.printStackTrace();//print error
        }
        return lines.toArray(new String[0]);//return the arraylist converted to an array
    }
    private static void csvAppend(String FileName, String str){
        //appends to the csv files
        try{//try
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName,true));//make a writer
            writer.append("\n");//write a new line
            writer.append(str);//write the line
            writer.close();//close the file
        } catch (IOException e) {//catch exception
            e.printStackTrace();//print error
        }
    }

    private static int Comparison(int[] Brute,int[] Mine){
        //compares the arrays
        for (int i = 0;i<Brute.length;i++){//for every element in the array
            if (Brute[i]!=Mine[i]) {//if that element is not equal to the corisponding element in ther other array
                return i;//return the index of which element is wrong
            }
        }
        return -1;//returns -1 if they are the same array
    }
}


