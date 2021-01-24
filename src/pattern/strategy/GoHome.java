package pattern.strategy;

/**
 * 策略模式的例子
 * @author Huijun Zhu
 * 2021/1/24
 */
public class GoHome {
    int go(int total, Moving movingStrategy){
        return movingStrategy.speedTime(total);
    }
    public static void main(String[] args) {
        new GoHome().go(800, new Car());
        new GoHome().go(800, new Walk());
    }
}
