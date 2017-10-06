package tasks.mergeSort;

import java.util.Comparator;
import java.util.Vector;

public class MergeSort implements DivideAndConquerable{

    int[] data;
    int[] aux;
    int left;
    int right;


    public MergeSort(int[] data, int[] aux ){
        this.data = data;
        this.aux = aux;

        this.left = 0;
        this.right = data.length-1;
    }

    public MergeSort(int[] data, int[] aux,int left,int right){
        this.data=data;
        this.aux=aux;
        this.left=left;
        this.right=right;

    }




    @Override
    public boolean isBase() {
        //Basisfall ist, wenn der Array die grösse 1 hat
        if(data.length == 1){
            return true;
        }
        return false;
    }

    @Override
    public int[] baseFun() {
        //Input zurückgeben -> ist dann bereits sortiert
        return data;
    }

    @Override
    public Vector<DivideAndConquerable> decompose() {
        //input wird halbiert -> Rückgabe wert linke und rechte hälfte: Liste von zwei Komponenten (links und rechts)
        int mid = (left + right)/2;
        int i = left;
        int j = mid+1;
        int k = left;
        System.arraycopy(data,i,aux,k,mid-i+1);
        System.arraycopy(aux,left,data,left,j-left);
        Vector<DivideAndConquerable> vectorList = new Vector<>();
        vectorList.add(new MergeSort(data,aux,left,mid));
        vectorList.add(new MergeSort(data,aux,mid+1,right));
        return vectorList;
    }

    @Override
    public int[] recompose(Vector intermediateresults) {
        //entspricht der while Schlaufe
        int mid =(left+right)/2;
        int i = left;
        int j = mid+1;
        int k = left;
        while(i<=mid && j<=right){
            if(data[i]<data[j]){
                aux[k++] = data[i++];
            }else{
                aux[k++] = data[j++];
            }
        }
        return aux;
    }


    public static void main(String[] args){
        int[] numbers = new int[]{4,6,2,3};
        int[] aux = new int[0];
        MergeSort m = new MergeSort(numbers,aux);
        Object res = m.divideAndConquer();
        System.out.println("RES: "+res);
    }
}
