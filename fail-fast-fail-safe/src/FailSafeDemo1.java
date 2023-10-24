import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
public class FailSafeDemo1 {
    public static void main(String[] args)
    {
        /**
         * 1. Sử dụng Concurrent<Type> không coppy sang object khác và làm việc với bản sao
         * 2. Làm việc trực tiếp với object chính và không bắn ra lỗi ConcurrentModificationException
         */
        // Initializing a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<>();
        map.put("ONE", 1); //Adding values
        map.put("SEVEN", 7);
        map.put("FIVE", 5);
        map.put("EIGHT", 8);
        map.put("ZERO", 0);
        map.put("TWO", 2);
        // Getting an iterator using map
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + " : " + map.get(key));
            // This will reflect in iterator.
            // This means it has not created separate copy of objects
            map.put("NINE", 9);
        }
    }
}
