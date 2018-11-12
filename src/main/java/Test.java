
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test implements ReversePolishNotation {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.calculate("12 2 3 4 * 10 5 / + * +"));

    }

    @Override
    public long calculate(String expression) {
        long result;
        long value;
        List<String> tab = new ArrayList<>(Arrays.asList(expression.split(" ")));

        if (tab.isEmpty()) {
            result = 0;
        } else {
            for (int i = 0; i < tab.size(); i++) {
                if (tab.get(i).equals("+")) {
                    value = Long.parseLong(tab.get(i - 2)) + Long.parseLong(tab.get(i - 1));
                    i = listUpDate(value, tab, i);
                } else if (tab.get(i).equals("-")) {
                    value = Long.parseLong(tab.get(i - 2)) - Long.parseLong(tab.get(i - 1));
                    i = listUpDate(value, tab, i);
                } else if (tab.get(i).equals("*")) {
                    value = Long.parseLong(tab.get(i - 2)) * Long.parseLong(tab.get(i - 1));
                    i = listUpDate(value, tab, i);
                } else if (tab.get(i).equals("/")) {
                    value = Long.parseLong(tab.get(i - 2)) / Long.parseLong(tab.get(i - 1));
                    i = listUpDate(value, tab, i);
                }

            }
            result = Long.parseLong(tab.get(0));
        }
        return result;
    }

    private int listUpDate(long value, List<String> tab, int i) {
        for (int j = 0; j < 3; j++) {
            tab.remove(i - 2);
        }
        tab.add(i - 2, String.valueOf(value));
        i = 0;
        return i;
    }
}
