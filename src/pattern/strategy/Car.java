package pattern.strategy;

/**
 * @author Huijun Zhu
 * 2021/1/24
 */
public class Car  implements Moving{
        @Override
        public int speedTime(int total) {
            int carSpeed = 80;
            int time = Math.round(total / carSpeed);
            System.out.println("car will speed "+ time +"hours.");
            return time;
        }
}
