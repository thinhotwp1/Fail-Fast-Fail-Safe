import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FailSafeDemo {
    public static void main(String args[])
    {
        /**
         * Sử dụng CopyOnWriteArrayList sẽ tạo một object và thực hiện thay đổi
         * trên bản sao đó thay vì thay đổi trực tiếp trên object và những thay đổi
         * trên bản sao sẽ được thực hiện an toàn sau khi hết iterator
         */
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<>(new Integer[] { 1, 7, 9, 11 });
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer)itr.next();
            System.out.println(i);
            if (i == 7)
                list.add(15); // It will not be printed  
            //This means it has created a separate copy of the collection  
        }
        System.out.println(list);
    }
}   