package CustomList;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<String>();

        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            sb.append(input).append("\n");
            if(input.toUpperCase().equals("END")){
                break;
            }
        }
        String[] commands = sb.toString().split("\n");
        int i=0;
        while(true){
            String[] command = commands[i++].split("\\s+");
            switch(command[0]){
                case "Add":
                    list.add(command[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Contains":
                    System.out.println(list.contains(command[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(command[1]));
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "END":
                    return;
            }
        }
    }
}
