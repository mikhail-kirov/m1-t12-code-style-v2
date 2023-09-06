import java.net.URI;
import java.util.Scanner;
import java.io.IOException;

public class DepositCalculator
{
    double calculateComplexPercent(double amount, double percent, int period) {
        double pay = amount * Math.pow((1 + percent / 12), 12 * period);
        return roundValue(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return roundValue(amount + amount * yearRate * period, 2);
    }

    double roundValue(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateСontribution()
    {
        int period;
        int action;
        Scanner abcdef = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = abcdef.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt( );

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();

        double out = 0;

        if (action == 1) {

            out = calculateSimplePercent(amount, 0.06, period);

        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateСontribution();
    }
}
