package tasks.divideAndConquer;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class FibonnaciImplementationWithMemorication implements DivideAndConquerableWithMemorication<Integer> {

    int number;
    Vector resList;
    Map<Integer,Integer> memMap;

    FibonnaciImplementationWithMemorication(int number){
        this.number = number;
        memMap = new HashMap<Integer,Integer>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
    public Vector<DivideAndConquerableWithMemorication<Integer>> decompose() {
        //Auseinandernehmen und neue Instanzen hinzufügen
        Vector<DivideAndConquerableWithMemorication<Integer>> vectorList = new Vector<>();
        vectorList.add(new FibonnaciImplementationWithMemorication(number-1));
        vectorList.add(new FibonnaciImplementationWithMemorication(number -2));
        return vectorList;
    }

    @Override
    public void memoize(DivideAndConquerableWithMemorication input, Integer output) {
        memMap.put(this.number,output);

    }

    @Override
    public Integer getMemoize(DivideAndConquerableWithMemorication input) {
        return memMap.get(this.number);
    }

    @Override
    public boolean hasMemoized(DivideAndConquerableWithMemorication input) {
        return memMap.containsKey(input);
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
        FibonnaciImplementationWithMemorication dc = new FibonnaciImplementationWithMemorication(5);
        int res = dc.divideAndConquer();
        System.out.println("RES: "+res);
        System.out.println("ResList: "+dc.resList);
    }
}
