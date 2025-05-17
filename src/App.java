import ShortCircuit;
import StringTest;
import CakeCase;
import randNum;
import CastingTest;
import BreakAndContinue;
import SwitchCake;
import Number;

public class App {
    public static void main(String[] args){
        Number.TestNumber();
        StringTest.test();
        ShortCircuit.test();
        CastingTest.testDouble();
        CastingTest.testCasting();
        CakeCase.cake(1);
        BreakAndContinue.WhileTest(10);
        BreakAndContinue.DoWhileTest(10);
        SwitchCake.switchCase();
        System.out.println(randNum.randNum());
    }
}