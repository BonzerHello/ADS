package tasks.divideAndConquer;

import java.util.Vector;

public class DivideAndConquerableImplementation implements DivideAndConquerable<Integer> {

    int number;

    DivideAndConquerableImplementation(int number){
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
        //AUseinandernehmen und neue Instanzen hinzufügen
        Vector<DivideAndConquerable<Integer>> vectorList = new Vector<DivideAndConquerable<Integer>>();
        vectorList.add(new DivideAndConquerableImplementation(number-1));
        vectorList.add(new DivideAndConquerableImplementation(number -2));
        return vectorList;
    }

    @Override
    public Integer recompose(Vector intermediateresults) {
        int res = 0;
        for (Object intermediateresult : intermediateresults) {
            res += (int) intermediateresult;
        }
        return res;
    }




    public static void main(String[] args){
        DivideAndConquerableImplementation dc = new DivideAndConquerableImplementation(5);
        int res = dc.divideAndConquer();
        System.out.println("RES: "+res);
    }
}
