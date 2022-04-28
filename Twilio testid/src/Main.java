import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        List<Integer> ar = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int n=9;
        sockMerchant(n, ar);
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int count =0;
        for (int i = 0; i < ar.size(); i++){
            for (int j = i + 1; j < ar.size(); j++) {
                if (Objects.equals(ar.get(i), ar.get(j))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
