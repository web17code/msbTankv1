package pattern.strategy;

/**
 * @author Huijun Zhu
 * 2021/1/24
 */
public class Walk implements Moving{
    @Override
    public int speedTime(int total) {
        int walk = 5;
        int time = Math.round(total / walk);
        System.out.println("walk will speed "+ time +"hours.");
        return time;
    }
}
