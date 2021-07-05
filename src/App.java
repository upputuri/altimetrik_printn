import java.util.Arrays;

public class App {
    private static String[] factorConfig = new String[] {
        "3:Srikanth",
        "5:Upputuri"

    };

    public static void main(String[] args) throws Exception {
        int counter = 0;
        int countTill = 0;

        try{
            countTill = Integer.parseInt(args[0]);
        }catch(Exception e){
            throw new IllegalArgumentException("Please pass a valid positive number", e);
        }
        System.out.println("Counting upto "+countTill);

        while(++counter <= countTill){
            final int i = counter;
            boolean hit = Arrays.stream(factorConfig).map((config) -> {
                String[] parts = config.split(":");
                if (i % Integer.parseInt(parts[0]) == 0){
                    System.out.print(parts[1]+" ");
                    return true;
                }
                else {
                    return false;
                }                
            }).reduce(false, (a, b) -> a || b);

            System.out.println(!hit ? counter: "");
        }
    }
}
