
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            List<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i <= 10; i++) {
                arrayList.add(i);
            }

// Получение размера списка
            int size1 = arrayList.size();
            System.out.println("Размер списка: " + size1);

            arrayList.remove(5);

            System.out.println(arrayList);



            // Получение размера списка
            int size = arrayList.size();
            System.out.println("Размер списка: " + size);

            System.out.println("getCapacity");
            getArrayListCapacity(arrayList);
        }

        private static void getArrayListCapacity(List<?> arrayList) {
            try {
                Field dataField = ArrayList.class.getDeclaredField("elementData");
                dataField.setAccessible(true);
                Object[] elementData = (Object[]) dataField.get(arrayList);
                int capacity = elementData.length;
                System.out.println("Емкость списка: " + capacity);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

