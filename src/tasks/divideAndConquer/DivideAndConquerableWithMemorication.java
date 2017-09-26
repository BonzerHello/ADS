package tasks.divideAndConquer;

import java.util.Vector;

public interface DivideAndConquerableWithMemorication<OutputType> {

    abstract boolean isBase();

    abstract OutputType baseFun();

    abstract Vector<DivideAndConquerableWithMemorication<OutputType>> decompose();

    abstract OutputType recompose(Vector<OutputType> intermediateresults);

    //Für Abspeicherung
    abstract void memoize(DivideAndConquerableWithMemorication input, OutputType output);

    abstract OutputType getMemoize(DivideAndConquerableWithMemorication input);

    abstract boolean hasMemoized(DivideAndConquerableWithMemorication input);

    default OutputType divideAndConquer() {
        if (isBase()) return baseFun();
        if(hasMemoized(this)){
            return getMemoize(this);
        }else{
            Vector<DivideAndConquerableWithMemorication<OutputType>> subcomponents = decompose();
            Vector<OutputType> intermediateresults = new Vector<OutputType>(
                    subcomponents.size());
            //subcomponents.parallelStream().forEach(
            subcomponents.forEach(
                    subcomponent -> intermediateresults.add(

                            subcomponent.divideAndConquer())
            );
            OutputType outputType = recompose(intermediateresults);
            memoize(this,outputType);

            return outputType;
        }

    }
}
