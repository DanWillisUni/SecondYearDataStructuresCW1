package com.company;
//import static com.company.CourseworkUtilities.generateDocument;
public class Main {
    public static void main(String[] args) {

    }
    private static int[] calculateFeatureVector(String[] A, String[] Q){
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
    private static int calculateDSD(int[] A, int[] B){
        //calculates the Document similarity distance and returns it
        int DSD = 0;//sets the document similarity distance to 0
        for (int w =0;w<A.length;w++){//for every word in document
            DSD=DSD + Math.abs(A[w] - B[w]);//add the absolute value of documentA feature vector subtract documentB feature vector to document similarity
        }
        return DSD;//return document similarity distance
    }
    public static int[] findNearestDocuments(String[][] Doc, String[] Q){
        int[] FND = new int[Doc.length];//initilise the find nearest document array
        int[][] distance = new int[Doc.length][Doc[0].length];//initilise the document
        int[][] F = new int[Doc.length][];//initilise the feature vector array
        for (int A = 0;A<Doc.length;A++){//for each document
            F[A] = calculateFeatureVector(Doc[A],Q);//calculate the feature vector and populate F array
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
}


