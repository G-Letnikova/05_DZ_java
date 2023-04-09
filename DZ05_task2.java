import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Пусть дан список сотрудников:
// Иван Иванов 
// Светлана Петрова
// Кристина Белова
// Анна Мусина 
// Анна Крутова
// Иван Юрин
// Петр Лыков 
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

public class DZ05_task2 {
    public static void main(String[] args) {
        Map <String,String> list = new HashMap<>();
        Map <String,Integer> freqList = new HashMap<>();

        String fileName = "list.txt";
        fillMap(list, fileName);

    
        for (var v: list.values()) { 
            if (freqList.containsKey(v)) 
                freqList.put(v,freqList.get(v)+1);
            else freqList.put(v,1);
        }

        while (!freqList.isEmpty()) {
            String keyMax = findIndexMaxValue(freqList);
            System.out.println(keyMax + " = " + freqList.get(keyMax));
            freqList.remove(keyMax);
        }

    }

    static String findIndexMaxValue(Map <String,Integer> list){
        String maxIndex = "";
        int maxValue = 0;

        for (var kv  : list.entrySet()) {
            if (kv.getValue() > maxValue) {
                maxValue = kv.getValue();
                maxIndex = kv.getKey();
            }
        }
        return maxIndex;
    }

    static void fillMap(Map <String,String> list, String fileName)  {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.put(line.split(" ")[1], line.split(" ")[0]);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }      
    
}
