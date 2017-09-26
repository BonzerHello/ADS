package tasks.divideAndConquer;

import java.util.Vector;

public class FibonnaciImplementation implements DivideAndConquerable<Integer> {

    int number;
    Vector resList;

    FibonnaciImplementation(int number){
        this.number = number;
    }



    @Override
    public boolean isBase() {
        if(this.number == 0 || this.number == 1) return true;
        return false;
    }

    @Override
    public Integer baseFun() {
        return this.number;
    }

    @Override
    public Vector<DivideAndConquerable<Integer>> decompose() {
        //Auseinandernehmen und neue Instanzen hinzufügen
        Vector<DivideAndConquerable<Integer>> vectorList = new Vector<DivideAndConquerable<Integer>>();
        vectorList.add(new FibonnaciImplementation(number-1));
        vectorList.add(new FibonnaciImplementation(number -2));
        return vectorList;
    }

    @Override
    public Integer recompose(Vector intermediateresults) {
        int res = 0;
        resList = intermediateresults;
        for (Object intermediateresult : intermediateresults) {
            if(intermediateresult instanceof Integer){
                res += (int) intermediateresult;
                System.out.println("Elem: "+intermediateresult);
            }
        }
        return res;
    }




    public static void main(String[] args){
        FibonnaciImplementation dc = new FibonnaciImplementation(5);
        int res = dc.divideAndConquer();
        System.out.println("RES: "+res);
        System.out.println("ResList: "+dc.resList);
    }
}
