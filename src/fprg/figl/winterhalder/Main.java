package fprg.figl.winterhalder;

import java.util.ArrayList;

/**
 * Created by richie on 03/12/15.
 */
public class Main {

    interface Ifold<I> {
        I foldFunc(I input1, I input2);
    }

    public static void main(String[] args) {

        //Integer
        ArrayList<Integer> inputInteger = new ArrayList<Integer>(){{
            add(3);
            add(7);
            add(15);
            add(44);
        }};

        Integer resultIntegerPlusOne = fold((x,y) -> ( x + y), 5, inputInteger);

        System.out.println("--------Integer--------");
        System.out.println("resultIntegerPlusOne: " + resultIntegerPlusOne);

    }

    private static <I> I fold(Ifold<I> func, I initialValue, ArrayList<I> input){
        return foldRec(func, initialValue, input, 0);
    }

    private static <I> I foldRec(Ifold<I> func, I startValue, ArrayList<I> input, int count){
        // abort
        if(count == input.size()) {
            return startValue;
        }
        startValue = func.foldFunc(startValue, input.get(count));
        return foldRec(func, startValue, input, count+1);
    }
}